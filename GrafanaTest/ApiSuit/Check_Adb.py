import os
import subprocess
import re


class CheckAdb:

    def __init__(self):
        print ("Checking Adb ...")

    def split_lines(self, s):
        """Splits lines in a way that works even on Windows and old devices.
        Windows will see \r\n instead of \n, old devices do the same, old devices
        on Windows will see \r\r\n.
        """
        # rstrip is used here to workaround a difference between splineslines and
        # re.split:
        # >>> 'foo\n'.splitlines()
        # ['foo']
        # >>> re.split(r'\n', 'foo\n')
        # ['foo', '']
        return re.split(r'[\r\n]+', s.rstrip())

    def get_devices(self, adb_path='adb'):
        with open(os.devnull, 'wb') as devnull:
            subprocess.check_call([adb_path, 'start-server'], stdout=devnull,
                                  stderr=devnull)
        out = self.split_lines(
            subprocess.check_output([adb_path, 'devices']).decode('utf-8'))
        # The first line of `adb devices` just says "List of attached devices", so
        # skip that.
        devices = []
        for line in out[1:]:
            if not line.strip():
                continue
            if 'offline' in line:
                continue
            serial, _ = re.split(r'\s+', line, maxsplit=1)
            devices.append(serial)
        return devices

