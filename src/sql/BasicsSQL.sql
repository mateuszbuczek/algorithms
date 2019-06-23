SELECT

SELECT name, population FROM world
WHERE name IN ('Sweden', 'Norway', 'Denmark');

SELECT name, area FROM world
WHERE area BETWEEN 200000 AND 250000

SELECT name, population
FROM world
WHERE name LIKE "Al%"

SELECT name, capital
FROM world
WHERE LEFT(name,1) = LEFT(capital,1)
AND name <> capital

-- Show the 1984 winners and subject ordered by subject and winner name; but list Chemistry and Physics last.
SELECT winner, subject
  FROM nobel
 WHERE yr=1984
 ORDER BY  subject IN ('Physics','Chemistry') ,subject, winner

SELECT IN SELECT

SELECT name FROM world
  WHERE population >
     (SELECT population FROM world
      WHERE name='Russia')

--       Which countries have a GDP greater than every country in Europe
SELECT name FROM world
WHERE gdp > ALL(SELECT gdp FROM world WHERE continent = 'Europe' AND gdp > 0)
7.
-- Find the largest country (by area) in each continent
SELECT continent, name, area FROM world x
  WHERE area >= ALL
    (SELECT area FROM world y
        WHERE y.continent=x.continent
          AND population>0)
--
SELECT id,stadium,team1,team2
  FROM game WHERE id = (SELECT matchid FROM goal WHERE player LIKE '%Bender')