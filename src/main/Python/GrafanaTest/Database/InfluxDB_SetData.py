from influxdb import InfluxDBClient


class InfluxClient:

    def __init__(self):
        print "Inside Influx"
        self.client = InfluxDBClient('localhost', 8086, 'root', 'root', 'example')

        result = self.client.query('select Int_value from App_Jenky_Frames;')
        print("Result: {0}".format(result))

    def create_database(self, var1):
        print "Create Database .."
        self.client.create_database(var1)

    def writedatafunc(self, var2):
        print "Write Data"
        self.client.write_points(var2)

# result = client.query('select value from cpu_load_short;')
# print("Result: {0}".format(result))
