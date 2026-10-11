# USE CASE: 9 provide number of given language speaker including world population percentage. show in descending order

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to look up the number of people that speak the languages a client has chosen* so that *I can present them in order in my report.*

### Scope

system.

### Level

user goal.

### Preconditions

Database has population data and language data for each country.

### Success End Condition

Analyst sees the amount of speakers for each language in order of highest to lowest with percentages nect to each.

### Failed End Condition

No results are found. An error message is shown.

### Primary Actor

data analyst.

### Trigger

data analyst asks for a language speaker figure.

## MAIN SUCCESS SCENARIO

1. data analyst picks the language speaker lookup.
2. system finds the number of speakers for each language.
3. system converts this to a percentage of the world population
4. system displays both outputs to the analyst.
5. data analyst adds the number to their report.

## EXTENSIONS

5. **no data is produced**:
    1. analyst tells the developers.

## SUB-VARIATIONS

none.

## SCHEDULE

**DUE DATE**: Release 0.5
