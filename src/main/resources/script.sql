SELECT * FROM MOVIES  where Genre='Sci-Fi';

SELECT * FROM MOVIES  where IMDB_SCORE>=6.5;

SELECT * FROM MOVIES  where Runtime<=100 and Rating='PG' OR Rating='G'

SELECT genre ,AVG( RUNTIME) FROM MOVIES  where IMDB_SCORE <7.5 group by genre

UPDATE Movies
SET Rating = 'R'
where Title='Starship Troopers'


select Id,rating from movies where genre='Horror' or genre='Documentary'

SELECT rating,AVG( IMDB_SCORE) ,MIN(IMDB_SCORE), MAX(IMDB_SCORE)FROM MOVIES  GROUP BY RATING

SELECT rating,AVG( IMDB_SCORE) ,MIN(IMDB_SCORE), MAX(IMDB_SCORE)FROM MOVIES  GROUP BY RATING HAVING COUNT(*) > 1
DELETE FROM MOVIES WHERE RATING='R';
