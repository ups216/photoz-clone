create table if not exists photoz (
    id identity primary key,
    file_name varchar(255),
    content_type varchar(255),
    FILE_CONTENT IMAGE(MAX)
);