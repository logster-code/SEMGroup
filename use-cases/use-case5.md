# USE CASE: 5 Produce a Population Report of people living in and not living in cities for each continent, region or country

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to see how many people live in cities and how many do not* so that *I can see how urban each area is.*

### Scope

system.

### Level

user goal.

### Preconditions

Database has country populations and city populations.

### Success End Condition

Analyst gets a population report. For each area it shows the name and total population. It also shows the population living in cities and not living in cities, each with a percentage.

### Failed End Condition

No report is made. An error message is shown.

### Primary Actor

data analyst.

### Trigger

data analyst asks for the population report.

## MAIN SUCCESS SCENARIO

1. data analyst picks the population report.
2. data analyst chooses the level: continent, region or country.
3. system adds up the total and city populations for each area.
4. system works out the population not living in cities.
5. system works out both percentages.
6. system shows the population report.
7. data analyst adds the data to their report.

## EXTENSIONS

3a. **an area has no cities in the database**:
    1. system shows 0 living in cities.
    2. system shows 100% not living in cities.

6a. **no data is produced**:
    1. analyst tells the developers.

## SUB-VARIATIONS

1. The level is continent.
2. The level is region.
3. The level is country.

## SCHEDULE

**DUE DATE**: Release 0.2
