import warnings

warnings.filterwarnings('ignore')
import threading
import requests
from Database.MysqlDB_SetData import *
from Utilities.json_file import *


# def call_API_devicename():
#     r = requests.get(url=url_devicename).text
#     calldevicename(r)
#     return calldevicename(r)
#
#
# def chronJob_devicename(arg):
#     try:
#         threading.Timer(5.0, chronJob_devicename, (arg,)).start()
#         str_val = call_API_devicename()
#         print str_val
#         if str_val:
#             arg.writedatafunc(str_val)
#     except ValueError:
#         print "No device connected"
#     except Exception as ConnectionError:
#         print "Device API down"


def call_api():
    r1 = requests.get(url=url_jenky).text
    #print "Jenky: " + str(r1)
    r2 = requests.get(url=url_cpuinfo).text
    #print "cpu: " + str(r2)
    r3 = requests.get(url=url_Memory).text
    #print "memory: " + str(r3)
    r4 = requests.get(url=url_devicename).text
    #print "DeviceName: " + str(r4)
    return r1, r2, r3, r4


def chronJob(arg):
    try:
        threading.Timer(5.0, chronJob, (arg,)).start()
        val1, val2, val3, val4 = call_api()
        if val4 != "No device connected":
            if val1 != "None" and val2 != "None" and val3 != "None":
                print "Start writing"
                arg.writedatafunc(val1, val2, val3)
            else:
                print "Unable to write. Getting API sending No data"
        else:
            print "No device connected"
    except Exception as e:
        print e
        print "API's down. ChronJob Failed"


if __name__ == '__main__':
    a = MysqlClient()
    a.create_database("myfirstdb")
    a.create_table()
    chronJob(a)
