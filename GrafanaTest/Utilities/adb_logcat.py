import os, re
import subprocess


def split_lines(s):
    """Splits lines in a way that works even on Windows and old devices.
    Windows will see \r\n instead of \n, old devices do the same, old devices
    on Windows will see \r\r\n.
    """
    return re.split(r'[\r\n]+', s.rstrip())


def get_logs():
    event_list = []
    log = split_lines(subprocess.check_output(['adb', 'logcat', '-d']))
    for line in log:
        if 'Event' in line and 'event_type' in line:
            _ = re.findall(r'\{(.*?)\}', line)
            __ = _[0].split(',')[2]
            event_list.append(__.split(':')[2])

    with open(os.devnull, 'wb') as devnull:
        subprocess.check_call(['adb', 'logcat', '-c'], stdout=devnull,
                              stderr=devnull)

    if event_list:
        return event_list
    return ""


def get_logs_api():
    api_list = []
    log = split_lines(subprocess.check_output(['adb', 'logcat', '-d']))
    for line in log:
        if 'OkHttp' and '<--' in line:
            if 'http' in line:
                res = line.split('<-- ')[1]
                _ = res.split(' ')
                if 'OK' in _:
                    _.remove('OK')
                api_list.append(_)

    with open(os.devnull, 'wb') as devnull:
        subprocess.check_call(['adb', 'logcat', '-c'], stdout=devnull,
                              stderr=devnull)

    if api_list:
        return api_list
    return ""


#print get_logs_api()
