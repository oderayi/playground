"""
vmstat monitoring 
"""

import sys, argparse

cmdOptions = []

def parseCmdOptions():
    parser = argparse.ArgumentParser()
    parser.add_argument("--column", type=int)
    parser.add_argument("--max_count", type=int)
    parser.add_argument("--max_value", type=int)
    cmdOptions = parser.parse_args()
    return cmdOptions

def parseVmstatLine(line):
    parsedLine = line.split()
    return parsedLine

cmdOptions =  parseCmdOptions()
persistentCount = 0
maxValueToMonitor = cmdOptions.max_value
maxCountToMonitor = cmdOptions.max_count

while True:
    line = sys.stdin.readline()
    print(line)
    parsedLine = parseVmstatLine(line)
    monitoredValue = parsedLine[cmdOptions.column]

    if(monitoredValue > maxValueToMonitor):
        persistentCount += 1
        if(persistentCount > maxCountToMonitor):
            print("Maximum threshold exceeded.")
            persistentCount = 0



