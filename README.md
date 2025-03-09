# stefan-stefanov-employees

## Getting Started
```from the start: 
mvn install 
```

For dev environment, it will run on localhost:8016
There are included static pages which will load on any browser.
Just type localhost:8016 and hit enter.
Working ui code can be found on:
https://github.com/sstefan0v/stefan-stefanov-employees-ui

The backend works with standard CSV files, which contain the following structure:
```
EmpID, ProjectID, DateFrom, DateTo
143, 12, 2013-11-01, 2014-01-05
218, 10, 2012-05-16, NULL
143, 10, 2009-01-01, 2011-04-27 
```

It is important to note that the present solution has some specifics, due to deadline limitations:
- There is nested static html pages, which normally are served via another server. For the sake of the demo, 
I imported them in the resources' folder.
- Also, it is limited by the size of CSV files. If 
larger size of data is required, the in-memory calculations can be replaced by introduction of a relational DB. The DB 
will persist all CSV records and will help the retrieval of the required data by utilizing its select statement 
capabilities.
- Test coverage is not full.