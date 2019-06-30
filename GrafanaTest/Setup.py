from distutils.core import setup
from setuptools import setup

setup(
    name='GrafanaTest',
    version='1.0',
    author='Dheeraj Bajaj',
    author_email='dheeraj.bajaj@wynk.in',
    packages=['ApiSuit', 'Database', 'PythonController', 'Utilities'],
    license='Creative Commons Attribution-Noncommercial-Share Alike license',
    long_description='Test Description ...', install_requires=['requests', 'flask', 'mysql-connector-python'])
