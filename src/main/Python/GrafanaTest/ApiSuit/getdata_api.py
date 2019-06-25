#!flask/bin/python
from flask import Flask
from getdata1 import GetData
import json

app = Flask(__name__)


@app.route('/getdevice', methods=['GET', 'OPTIONS'])
def getdevicefunc():
    try:
        devicename = str(GetData().get_devices("adb")[0])
        return devicename
    except Exception as e:
        return "No device connected"


@app.route('/getjenky', methods=['GET', 'OPTIONS'])
def getjenkyfunc():
    return str(GetData().getJenkyFrames())


@app.route('/getmeminfo', methods=['GET', 'OPTIONS'])
def getmeminfofunc():
    return str(GetData().getmeminfo("tv.accedo.airtel.wynk.debug"))


@app.route('/getcpucores', methods=['GET', 'OPTIONS'])
def getcpufunc():
    return str(GetData().getcpucores())


@app.route('/getframestats', methods=['GET', 'OPTIONS'])
def getframefunc():
    return str(GetData().getframestats("tv.accedo.airtel.wynk.debug"))


@app.route('/getcpu', methods=['GET', 'OPTIONS'])
def getcpuinfofunc():
    return str(GetData().getcpuinfo("tv.accedo.airtel.wynk.debug"))


if __name__ == '__main__':
    app.run(host='127.0.0.1', port='5003', debug=True)
    # app.run(host='0.0.0.0', debug=True)
