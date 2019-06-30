import warnings
import threading

warnings.filterwarnings('ignore')
import threading
import requests
from Database.MysqlDB_SetData import *
from Utilities.json_file import *
from Utilities.adb_logcat import *

list_val1 = []
list_val2 = []
list_val3 = []


def call_api():
    r1 = requests.get(url=url_jenky).text
    r2 = requests.get(url=url_cpuinfo).text
    r3 = requests.get(url=url_Memory).text
    r4 = requests.get(url=url_devicename).text
    return r1, r2, r3, r4


def check_for_spike(val1, val2, val3):
    jenky_logs = diff_calculator_jenky(val1, max_jenky=3)
    cpu_logs = diff_calculator_cpu(val2, max_cpu=1)
    memory_logs = diff_calculator_memory(val3, max_memory=50000)

    if jenky_logs or memory_logs or cpu_logs:
        return True
    return False


def chronJob(arg):
    try:
        threading.Timer(5.0, chronJob, (arg,)).start()
        val1, val2, val3, val4 = call_api()
        print val3
        if val4 != "No device":
            if val1 != "None" and val2 != "None" and val3 != "None":
                if check_for_spike(int(val1), int(float(val2)), int(float(val3))):
                    print "Catching Logs"
                    a = str(get_logs())
                    print "dheeraj" + a
                    if a:
                        arg.writedatafunc(val1, val2, val3, a)
                else:
                    arg.writedatafunc(val1, val2, val3, "None")
                    b = get_logs_api()
                    print "Dheeraj" + str(b)
                    if b:
                        arg.write_api_func(b)
            else:
                print "Unable to write.API sending no data"
        else:
            print "No device"
    except Exception as e:
        print e
        print "API's down. ChronJob Failed"


if __name__ == '__main__':
    a = MysqlClient()
    a.create_database("myfirstdb")
    a.create_table()
    chronJob(a)
