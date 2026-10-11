# USE CASE: 6 Find the population of the world, a continent, a region, a country, a district or a city

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to look up the population of a place* so that *I can use the number in my report.*

### Scope

system.

### Level

user goal.

### Preconditions

Database has population data for countries and cities.

### Success End Condition

Analyst sees the population of the place they asked for.

### Failed End Condition

No number is shown. An error message is shown.

### Primary Actor

data analyst.

### Trigger

data analyst asks for a population figure.

## MAIN SUCCESS SCENARIO

1. data analyst picks the population lookup.
2. data analyst chooses what to look up: world, continent, region, country, district or city.
3. data analyst enters the name if needed.
4. system finds the population.
5. system shows the population.
6. data analyst adds the number to their report.

## EXTENSIONS

3a. **name is not in the database**:
    1. system shows an error.
    2. system asks for the name again.

3b. **name matches more than one place**:
    1. system asks the analyst to be more specific.

5a. **no data is produced**:
    1. analyst tells the developers.

## SUB-VARIATIONS

1. The world.
2. A continent.
3. A region.
4. A country.
5. A district.
6. A city.

## SCHEDULE

**DUE DATE**: Release 0.2
