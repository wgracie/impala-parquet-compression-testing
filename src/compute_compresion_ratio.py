#!/bin/python

import os
from commands import getstatusoutput

suffix = ['text_nocompress', 'parquet_none', 'parquet_snappy', 'parquet_gzip']
title = ['Data Types', 'Column Cardinality',
         'Text no compression',
         'Parquet no compression', 'Parquet no compression Ratio',
         'Parquet Snappy', 'Parquet Snappy Ratio',
         'Parquet Gzip', 'Parquet Gzip Ratio',
         ]

out_file = 'result.txt'

def get_hdfs_size(table_name):
    ''' get the total size of impala tables '''
    if not table_name:
        return ''
    cmd = 'hdfs dfs -du -h -s %s'%(table_name)
    rtd, output = getstatusoutput(cmd)
    # process the output
    print output
    out = output.split()
    print out
    if out:
        out.pop() # remove the folder path

    if not out: # no output
        out = 0
    elif len(out) == 1 or not out[1].strip(): # no unit
        out = int(out[0])
    else:
        out = ''.join(out)
    print out
    return out

def main():
    result = {}
    cmd = 'hdfs dfs -ls /user/hive/warehouse'
    rtd, output = getstatusoutput(cmd)

    for line in output.split('\n')[1:]:
        tmp = line.split()
        if tmp:
            folder = tmp[-1]
            if not folder.endswith('text'):
                key = os.path.basename(folder)
                tmp = key.split('_')
                total_key = '%s_%s'%(tmp[0], tmp[1])
                key = key[len(total_key)+1:]
                if total_key in result:
                    result[total_key][key] = get_hdfs_size(folder)
                else:
                    result[total_key] = {}
                    result[total_key][key] = get_hdfs_size(folder)
    print result
    fp = open(out_file, 'w')
    fp.write('\t'.join(title))
    fp.write('\n')
    for key in sorted(result.keys()):
        print '---'*8
        print key
        base = result[key]['text_nocompress']
        print base
        fp.write('\t'.join(key.split('_')))
        fp.write('\t')
        fp.write(base)
        fp.write('\t')
        for sub_key in suffix[1:]:
            fp.write(result[key][sub_key])
            fp.write('\t')
            ratio = (base-result[key][sub_key])*100/base
            fp.write('%.2f%%\t'%ratio)
        fp.write('\n')

if __name__ == '__main__':
    import sys
    main()
