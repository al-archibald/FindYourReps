
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'reps_db' AND pid <> pg_backend_pid();

DROP DATABASE IF EXISTS reps_db;

DROP USER IF EXISTS final_capstone_owner;
DROP USER IF EXISTS final_capstone_appuser;