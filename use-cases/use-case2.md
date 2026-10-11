# USE CASE: 2 Produce a Report on the top N populated countries of the world, a continent or a region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to find the top N most populated countries in the world, a continent or a region* so that *I can focus my report on the biggest countries.*

### Scope

system.

### Level

user goal.

### Preconditions

Database has country population data. Analyst knows the area and the value of N.

### Success End Condition

Analyst gets a country report of the N biggest countries. It shows Code, Name, Continent, Region, Population and Capital. It is ordered from largest to smallest.

### Failed End Condition

No report is made. An error message is shown.

### Primary Actor

data analyst.

### Trigger

data analyst asks for the top N countries report.

## MAIN SUCCESS SCENARIO

1. data analyst picks the top N countries report.
2. data analyst chooses the area: world, continent or region.
3. data analyst enters the name of the continent or region if needed.
4. data analyst enters N.
5. system finds the countries in that area, biggest first, and keeps the first N.
6. system shows the country report.
7. data analyst adds the data to their report.

## EXTENSIONS

3a. **continent or region does not exist**:
    1. system shows an error.
    2. system asks for the area again.

4a. **N is not a positive whole number**:
    1. system shows an error.
    2. system asks for N again.

4b. **N is bigger than the number of countries in the area**:
    1. system shows all the countries in the area.

6a. **no data is produced**:
    1. analyst tells the developers.

## SUB-VARIATIONS

1. The area is the world.
2. The area is a continent.
3. The area is a region.

## SCHEDULE

**DUE DATE**: Release 0.2
