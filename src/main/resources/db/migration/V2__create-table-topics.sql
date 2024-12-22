CREATE TABLE if not exists topics (
    id serial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    author VARCHAR(255) NOT NULL,
    course VARCHAR(50) CHECK (course IN ('JAVA', 'JAVASCRIPT', 'MYSQL', 'SOFTSKILLS', 'CSS')) NOT NULL,
    CONSTRAINT unique_title UNIQUE (title)
);