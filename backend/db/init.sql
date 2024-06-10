SELECT 'CREATE DATABASE multimeet'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'multimeet')\gexec