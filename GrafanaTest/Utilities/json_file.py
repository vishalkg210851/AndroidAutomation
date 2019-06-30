url_jenky = "http://127.0.0.1:5003/getjenky"
url_devicename = "http://127.0.0.1:5003/getdevice"
url_cpuinfo = "http://127.0.0.1:5003/getcpu"
url_Memory = "http://127.0.0.1:5003/getmeminfo"

list_val1 = []
list_val2 = []
list_val3 = []


def diff_calculator_jenky(arg, max_jenky):
    global list_val1
    if len(list_val1) < 2:
        list_val1.append(arg)
        #print list_val1

    elif 2 <= len(list_val1) < 4:
        list_val1.append(arg)
        #print list_val1
        diff1 = abs(max(list_val1) - min(list_val1))
        print "diff1: " + str(diff1)
        if diff1 > int(max_jenky):
            #print "Need to catch Logs now"
            del list_val1[:]
            return True
        return False

    elif len(list_val1) == 4:
        list_val1.append(arg)
        #print list_val1
        print "diff1: " + str(abs(max(list_val1) - min(list_val1)))
        if abs(max(list_val1) - min(list_val1)) > int(max_jenky):
            #print "Need to catch Logs now"
            del list_val1[:]
            return True
        del list_val1[:]
        return False


def diff_calculator_cpu(arg, max_cpu):
    global list_val2
    if len(list_val2) < 2:
        list_val2.append(arg)
        #print list_val2

    elif 2 <= len(list_val2) < 4:
        list_val2.append(arg)
        #print list_val2
        diff2 = abs(max(list_val2) - min(list_val2))
        print "diff2: " + str(diff2)
        if diff2 > int(max_cpu):
            #print "Need to catch Logs now"
            del list_val2[:]
            return True
        return False

    elif len(list_val2) == 4:
        list_val2.append(arg)
        #print list_val2
        print "diff2: " + str(abs(max(list_val2) - min(list_val2)))
        if abs(max(list_val2) - min(list_val2)) > int(max_cpu):
            #print "Need to catch Logs now"
            del list_val2[:]
            return True
        del list_val2[:]
        return False


def diff_calculator_memory(arg, max_memory):
    global list_val3
    if len(list_val3) < 2:
        list_val3.append(arg)
        #print list_val3

    elif 2 <= len(list_val3) < 4:
        list_val3.append(arg)
        #print list_val3
        diff3 = abs(max(list_val3) - min(list_val3))
        print "diff3: " + str(diff3)
        if diff3 > int(max_memory):
            #print "Need to catch Logs now"
            del list_val3[:]
            return True
        return False

    elif len(list_val3) == 4:
        list_val3.append(arg)
        #print list_val3
        print "diff3: " + str(abs(max(list_val3) - min(list_val3)))
        if abs(max(list_val3) - min(list_val3)) > int(max_memory):
            #print "Need to catch Logs now"
            del list_val3[:]
            return True
        del list_val3[:]
        return False
