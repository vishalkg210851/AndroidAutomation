import mysql.connector
from mysql.connector import Error


class MysqlClient:

    def __init__(self):
        print "Inside Mysql"
        try:
            self.conn = mysql.connector.connect(host='127.0.0.1', user='root', password='password',
                                                auth_plugin='mysql_native_password')
            self.mycursor = self.conn.cursor()
            print('Connected to MySQL database')

        except Error as e:
            print(e)

    def create_database(self, var1):
        print "Create Database .."
        self.dbname = var1
        self.mycursor.execute("CREATE DATABASE IF NOT EXISTS " + var1)
        self.mycursor.execute("set sql_mode=''")

    def create_table(self):
        print "Create App table .."
        self.mycursor.execute("USE " + self.dbname)
        self.mycursor.execute(
            "CREATE TABLE IF NOT EXISTS AppPerformance ( "
            "jenky INTEGER, cpu FLOAT, memory INTEGER, event VARCHAR(500), time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")

        print "Create Api table .."
        self.mycursor.execute("USE " + self.dbname)
        self.mycursor.execute(
            "CREATE TABLE IF NOT EXISTS Api ( "
            "api VARCHAR(500), status VARCHAR(50), responsetime VARCHAR(50), time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)")

    def writedatafunc(self, var2, var3, var4, var5):

        print "Write Data"
        sql = "INSERT INTO AppPerformance VALUES (%s, %s, %s, %s, now())"
        if var5 is None:
            var5 = "None"
        print var5
        val = (var2, var3, var4, var5,)
        self.mycursor.execute(sql, val)
        self.conn.commit()
        print "Recorded Successfully"

    def write_api_func(self, var6):
        print "Write Data"
        for i in range(len(var6)):
            url, status, resp = var6[i][1], var6[i][0], var6[i][2]
            if 'event' not in url:
                sql = "INSERT INTO Api VALUES (%s, %s, %s, now())"
                val = (url, status, resp)
                self.mycursor.execute(sql, val)
                self.conn.commit()
        print "Recorded Successfully"
