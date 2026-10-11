# USE CASE: 6 Produce a Report on the top N populated capital cities of the world, a continent or a region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to see the top N populated capital cities from in the world, a continent or a region* so that *I can compare the most populated capitals in my report.*

### Scope

system.

### Level

user goal.

### Preconditions

Database has city population data. Database knows the capital of each country.

### Success End Condition

Analyst gets a capital city report. It shows Name, Country and Population. It is ordered from largest to smallest by population and is only the top N most populated.

### Failed End Condition

No report is made. An error message is shown.

### Primary Actor

data analyst.

### Trigger

data analyst asks for the capital city report.

## MAIN SUCCESS SCENARIO

1. data analyst picks the capital city report.
2. data analyst chooses the area: world, continent or region.
3. data analyst enters the name of the continent or region if needed.
4. data analyst enters N
5. system finds the capital cities in that area, biggest first.
6. system shows the capital city report.
7. data analyst adds the data to their report.

## EXTENSIONS

3. **continent or region does not exist**:
    1. system shows an error.
    2. system asks for the area again.

4. **N is not a positive integer**
    1. system shows an error.
    2. system asks for N again.

5. **a country has no capital in the database**:
    1. system leaves that country out.

6. **no data is produced**:
    1. analyst tells the developers.

## SUB-VARIATIONS

1. The area can be the world, a continent or a region.

## SCHEDULE

**DUE DATE**: Release 0.3
