# impala-parquet-compression-testing

Investigte parquet compression ratios for parquet none, parquet snappy, parquet gzip 
for various data types and various column cardinality.

Conclusion:
Column cardinality has big effect on compression ratio. When column has the same value, no matter what data types, the compression can reached above 97%.

For boolean, compression ratio are  almost  the same for parquet no compression, parquet snappy and parquet gzip.
For other data types, gzip > snappy > none.

If column values are incremental, the compression is bigger than random values.

For string values, if using parquet no compression, the ratio is negative for random and incremental values.

Row numbers has no big effect on compression ratio.

