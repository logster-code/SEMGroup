# USE CASE: 4 Produce a Report on the top N populated cities of the world, a continent, a region, a country or a district 
## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to find the top N most populated cities in the world, a continent, a region, a country or a district* so that *I can focus my report on the biggest cities.*

### Scope

system.

### Level

user goal.

### Preconditions

Database has city population data.

### Success End Condition

Analyst gets a city report of the N most populated cities. It shows Name, Country, District and Population. It is ordered from largest to smallest.

### Failed End Condition

No report is made. An error message is shown.

### Primary Actor

data analyst.

### Trigger

data analyst asks for the city report.

## MAIN SUCCESS SCENARIO

1. data analyst picks the city report.
2. data analyst chooses the area: world, continent, region, country or district.
3. data analyst enters the name of the area if needed.
4. data analyst enters N
5. system finds the cities in that area, biggest first.
6. system shows the city report.
7. data analyst adds the data to their report.

## EXTENSIONS

3. **area does not exist**:
   1. system shows an error.
   2. system asks for the area again.

4. **N is not a positive integer**
   1. system shows an error.
   2. system asks for N again.

5. **no cities are found in the area**:
   1. system says there are no cities to report.

6. **no data is produced**:
    1. analyst tells the developers.

## SUB-VARIATIONS

1. The area can be the world, a continent, a region, a country or a district.
2. Top N: analyst also enters N. System shows only the N biggest cities. If N is not a positive whole number, system shows an error and asks again.

## SCHEDULE

**DUE DATE**: Release 0.3
