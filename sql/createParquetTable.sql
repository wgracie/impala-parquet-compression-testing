create table int_same_parquet_none(x INT) stored as parquet;
set compression_codec=none;
insert into int_same_parquet_none select x from int_same_text;
create table int_diff_parquet_none(x INT) stored as parquet;
set compression_codec=none;
insert into int_diff_parquet_none select x from int_diff_text;
create table int_increm_parquet_none(x INT) stored as parquet;
set compression_codec=none;
insert into int_increm_parquet_none select x from int_increm_text;

create table int_same_parquet_snappy(x INT) stored as parquet;
set compression_codec=snappy;
insert into int_same_parquet_snappy select x from int_same_text;
create table int_diff_parquet_snappy(x INT) stored as parquet;
set compression_codec=snappy;
insert into int_diff_parquet_snappy select x from int_diff_text;
create table int_increm_parquet_snappy(x INT) stored as parquet;
set compression_codec=snappy;
insert into int_increm_parquet_snappy select x from int_increm_text;

create table int_same_parquet_gzip(x INT) stored as parquet;
set compression_codec=gzip;
insert into int_same_parquet_gzip select x from int_same_text;
create table int_diff_parquet_gzip(x INT) stored as parquet;
set compression_codec=gzip;
insert into int_diff_parquet_gzip select x from int_diff_text;
create table int_increm_parquet_gzip(x INT) stored as parquet;
set compression_codec=gzip;
insert into int_increm_parquet_gzip select x from int_increm_text;

create table double_same_parquet_none(x DOUBLE) stored as parquet;
set compression_codec=none;
insert into double_same_parquet_none select x from double_same_text;
create table double_diff_parquet_none(x DOUBLE) stored as parquet;
set compression_codec=none;
insert into double_diff_parquet_none select x from double_diff_text;
create table double_increm_parquet_none(x DOUBLE) stored as parquet;
set compression_codec=none;
insert into double_increm_parquet_none select x from double_increm_text;

create table double_same_parquet_snappy(x DOUBLE) stored as parquet;
set compression_codec=snappy;
insert into double_same_parquet_snappy select x from double_same_text;
create table double_diff_parquet_snappy(x DOUBLE) stored as parquet;
set compression_codec=snappy;
insert into double_diff_parquet_snappy select x from double_diff_text;
create table double_increm_parquet_snappy(x DOUBLE) stored as parquet;
set compression_codec=snappy;
insert into double_increm_parquet_snappy select x from double_increm_text;

create table double_same_parquet_gzip(x DOUBLE) stored as parquet;
set compression_codec=gzip;
insert into double_same_parquet_gzip select x from double_same_text;
create table double_diff_parquet_gzip(x DOUBLE) stored as parquet;
set compression_codec=gzip;
insert into double_diff_parquet_gzip select x from double_diff_text;
create table double_increm_parquet_gzip(x DOUBLE) stored as parquet;
set compression_codec=gzip;
insert into double_increm_parquet_gzip select x from double_increm_text;

create table boolean_same_parquet_none(x BOOLEAN) stored as parquet;
set compression_codec=none;
insert into boolean_same_parquet_none select x from boolean_same_text;
create table boolean_diff_parquet_none(x BOOLEAN) stored as parquet;
set compression_codec=none;
insert into boolean_diff_parquet_none select x from boolean_diff_text;
create table boolean_increm_parquet_none(x BOOLEAN) stored as parquet;
set compression_codec=none;
insert into boolean_increm_parquet_none select x from boolean_increm_text;

create table boolean_same_parquet_snappy(x BOOLEAN) stored as parquet;
set compression_codec=snappy;
insert into boolean_same_parquet_snappy select x from boolean_same_text;
create table boolean_diff_parquet_snappy(x BOOLEAN) stored as parquet;
set compression_codec=snappy;
insert into boolean_diff_parquet_snappy select x from boolean_diff_text;
create table boolean_increm_parquet_snappy(x BOOLEAN) stored as parquet;
set compression_codec=snappy;
insert into boolean_increm_parquet_snappy select x from boolean_increm_text;

create table boolean_same_parquet_gzip(x BOOLEAN) stored as parquet;
set compression_codec=gzip;
insert into boolean_same_parquet_gzip select x from boolean_same_text;
create table boolean_diff_parquet_gzip(x BOOLEAN) stored as parquet;
set compression_codec=gzip;
insert into boolean_diff_parquet_gzip select x from boolean_diff_text;
create table boolean_increm_parquet_gzip(x BOOLEAN) stored as parquet;
set compression_codec=gzip;
insert into boolean_increm_parquet_gzip select x from boolean_increm_text;

create table string_same_parquet_none(x STRING) stored as parquet;
set compression_codec=none;
insert into string_same_parquet_none select x from string_same_text;
create table string_diff_parquet_none(x STRING) stored as parquet;
set compression_codec=none;
insert into string_diff_parquet_none select x from string_diff_text;
create table string_increm_parquet_none(x STRING) stored as parquet;
set compression_codec=none;
insert into string_increm_parquet_none select x from string_increm_text;

create table string_same_parquet_snappy(x STRING) stored as parquet;
set compression_codec=snappy;
insert into string_same_parquet_snappy select x from string_same_text;
create table string_diff_parquet_snappy(x STRING) stored as parquet;
set compression_codec=snappy;
insert into string_diff_parquet_snappy select x from string_diff_text;
create table string_increm_parquet_snappy(x STRING) stored as parquet;
set compression_codec=snappy;
insert into string_increm_parquet_snappy select x from string_increm_text;

create table string_same_parquet_gzip(x STRING) stored as parquet;
set compression_codec=gzip;
insert into string_same_parquet_gzip select x from string_same_text;
create table string_diff_parquet_gzip(x STRING) stored as parquet;
set compression_codec=gzip;
insert into string_diff_parquet_gzip select x from string_diff_text;
create table string_increm_parquet_gzip(x STRING) stored as parquet;
set compression_codec=gzip;
insert into string_increm_parquet_gzip select x from string_increm_text;

create table timestamp_same_parquet_none(x TIMESTAMP) stored as parquet;
set compression_codec=none;
insert into timestamp_same_parquet_none select x from timestamp_same_text;
create table timestamp_diff_parquet_none(x TIMESTAMP) stored as parquet;
set compression_codec=none;
insert into timestamp_diff_parquet_none select x from timestamp_diff_text;
create table timestamp_increm_parquet_none(x TIMESTAMP) stored as parquet;
set compression_codec=none;
insert into timestamp_increm_parquet_none select x from timestamp_increm_text;

create table timestamp_same_parquet_snappy(x TIMESTAMP) stored as parquet;
set compression_codec=snappy;
insert into timestamp_same_parquet_snappy select x from timestamp_same_text;
create table timestamp_diff_parquet_snappy(x TIMESTAMP) stored as parquet;
set compression_codec=snappy;
insert into timestamp_diff_parquet_snappy select x from timestamp_diff_text;
create table timestamp_increm_parquet_snappy(x TIMESTAMP) stored as parquet;
set compression_codec=snappy;
insert into timestamp_increm_parquet_snappy select x from timestamp_increm_text;


create table timestamp_same_parquet_gzip(x TIMESTAMP) stored as parquet;
set compression_codec=gzip;
insert into timestamp_same_parquet_gzip select x from timestamp_same_text;
create table timestamp_diff_parquet_gzip(x TIMESTAMP) stored as parquet;
set compression_codec=gzip;
insert into timestamp_diff_parquet_gzip select x from timestamp_diff_text;
create table timestamp_increm_parquet_gzip(x TIMESTAMP) stored as parquet;
set compression_codec=gzip;
insert into timestamp_increm_parquet_gzip select x from timestamp_increm_text;


