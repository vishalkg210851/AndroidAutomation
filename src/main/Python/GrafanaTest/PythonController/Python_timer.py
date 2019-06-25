import warnings
warnings.filterwarnings('ignore')
import threading, sys
import requests
from Database.InfluxDB_SetData import *
from Utilities.json_file import *


def call_API_devicename():
    r = requests.get(url=url_devicename).text
    calldevicename(r)
    return calldevicename(r)


def chronJob_devicename(arg):
    try:
        threading.Timer(5.0, chronJob_devicename, (arg,)).start()
        str_val = call_API_devicename()
        print str_val
        if str_val:
            arg.writedatafunc(str_val)
    except ValueError:
        print "No device connected"
    except Exception as ConnectionError:
        print "Device API down"


def call_API_Jenky():
    r = requests.get(url=url_jenky).text
    callApiJenky(r)
    return callApiJenky(r)


def chronJob_Jenky(arg):
    try:
        threading.Timer(5.0, chronJob_Jenky, (arg,)).start()
        int_val = call_API_Jenky()
        print int_val
        if int_val:
            arg.writedatafunc(int_val)
    except ValueError:
        print "No Jenky Frames.Error while adding to database"
    except Exception as ConnectionError:
        print "Jenky API down"


def call_API_CPU():
    r = requests.get(url=url_cpuinfo).text
    callApiCPU(r)
    return callApiCPU(r)


def chronJob_CPU(arg):
    try:
        threading.Timer(5.0, chronJob_CPU, (arg,)).start()
        float_val = call_API_CPU()
        print float_val
        if float_val:
            arg.writedatafunc(float_val)
    except ValueError:
        print "No CPU data .Error while adding to database"
    except Exception as ConnectionError:
        print "CPU API down"


def call_API_Memory():
    r = requests.get(url=url_Memory).text
    callApiMemory(r)
    return callApiMemory(r)


def chronJob_Memory(arg):
    try:
        threading.Timer(5.0, chronJob_Memory, (arg,)).start()
        int_val_memory = call_API_Memory()
        print int_val_memory
        if int_val_memory:
            arg.writedatafunc(int_val_memory)
    except ValueError:
        print "No Memory data.Error while adding to database"
    except Exception as ConnectionError:
        print "Memory API down"


if __name__ == '__main__':
    a = InfluxClient()
    a.create_database("Test1")
    chronJob_devicename(a)
    chronJob_Jenky(a)
    chronJob_CPU(a)
    chronJob_Memory(a)
