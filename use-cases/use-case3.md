# USE CASE: 3 Produce a Report on the cities of the world, a continent, a region, a country or a district organised by population

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to see cities in an area from biggest to smallest* so that *I know where people live and can plan for them.*

### Scope

system.

### Level

user goal.

### Preconditions

Database has city population data.

### Success End Condition

Analyst gets a city report. It shows Name, Country, District and Population. It is ordered from largest to smallest.

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
4. system finds the cities in that area, biggest first.
5. system shows the city report.
6. data analyst adds the data to their report.

## EXTENSIONS

3a. **area does not exist**:
    1. system shows an error.
    2. system asks for the area again.

4a. **no cities are found in the area**:
    1. system says there are no cities to report.

5a. **no data is produced**:
    1. analyst tells the developers.

## SUB-VARIATIONS

1. The area can be the world, a continent, a region, a country or a district.
2. Top N: analyst also enters N. System shows only the N biggest cities. If N is not a positive whole number, system shows an error and asks again.

## SCHEDULE

**DUE DATE**: Release 0.2
