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

Result for 1000 rows:
Data Types	Column Cardinality	Text no compression	Parquet no compression	Parquet no compression Ratio	Parquet Snappy	Parquet Snappy Ratio	Parquet Gzip	Parquet Gzip Ratio
boolean	diff	5466	342	93.00%	346	93.00%	365	93.00%
boolean	increm	5500	342	93.00%	346	93.00%	365	93.00%
boolean	same	5000	342	93.00%	221	95.00%	234	95.00%
double	diff	18982	9499	49.00%	9509	49.00%	9111	52.00%
double	increm	12612	9499	24.00%	8119	35.00%	6345	49.00%
double	same	9000	237	97.00%	241	97.00%	279	96.00%
int	diff	10456	5492	47.00%	5502	47.00%	5538	47.00%
int	increm	12000	5492	54.00%	5502	54.00%	4762	60.00%
int	same	11000	233	97.00%	237	97.00%	278	97.00%
string	diff	21000	25503	-22.00%	23723	-13.00%	17565	16.00%
string	increm	21000	25503	-22.00%	14430	31.00%	10180	51.00%
string	same	21000	260	98.00%	264	98.00%	300	98.00%
timestamp	diff	30000	13503	54.00%	12291	59.00%	10443	65.00%
timestamp	increm	30000	13503	54.00%	7428	75.00%	6352	78.00%
timestamp	same	30000	241	99.00%	245	99.00%	286	99.00%
Result for 10000 rows:
Data Types	Column Cardinality	Text no compression	Parquet no compression	Parquet no compression Ratio	Parquet Snappy	Parquet Snappy Ratio	Parquet Gzip	Parquet Gzip Ratio
boolean	diff	55046	1473	97.32%	1478	97.31%	1496	97.28%
boolean	increm	55000	1473	97.32%	1478	97.31%	1496	97.28%
boolean	same	55000	1473	97.32%	287	99.48%	247	99.55%
double	diff	189906	97780	48.51%	97798	48.50%	92757	51.16%
double	increm	134184	97492	27.34%	90350	32.67%	67816	49.46%
double	same	90000	244	99.73%	248	99.72%	285	99.68%
int	diff	104794	57780	44.86%	57795	44.85%	57318	45.30%
int	increm	120000	57636	51.97%	57651	51.96%	52261	56.45%
int	same	110000	240	99.78%	244	99.78%	284	99.74%
string	diff	210021	257780	-22.74%	239785	-14.17%	177200	15.63%
string	increm	210021	257780	-22.74%	146695	30.15%	102865	51.02%
string	same	210000	267	99.87%	271	99.87%	306	99.85%
timestamp	diff	300030	137780	54.08%	122501	59.17%	101924	66.03%
timestamp	increm	300030	137348	54.22%	75649	74.79%	57181	80.94%
timestamp	same	300030	248	99.92%	254	99.92%	292	99.90%
Result for Different Column Cardinality, total rows = 1000
Data Types	Column Cardinality	Text no compression	Parquet no compression	Parquet no compression Ratio	Parquet Snappy	Parquet Snappy Ratio	Parquet Gzip	Parquet Gzip Ratio
string	1	21000	260	98.00%	264	98.00%	300	98.00%
string	10	21000	981	95.00%	979	95.00%	923	95.00%
string	100	21000	3517	83.00%	3374	83.00%	2777	86.00%
string	500	21000	13378	36.00%	12490	40.00%	9422	55.00%
string	1000	21000	25503	-22.00%	23721	-13.00%	17581	16.00%
