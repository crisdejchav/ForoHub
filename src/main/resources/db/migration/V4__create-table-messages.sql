CREATE TABLE if not exists messages (
    id serial PRIMARY KEY,
  	m_content TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    author VARCHAR(255) NOT NULL,
    topic_id BIGINT,
    FOREIGN KEY (topic_id) REFERENCES topics(id) ON DELETE CASCADE
);