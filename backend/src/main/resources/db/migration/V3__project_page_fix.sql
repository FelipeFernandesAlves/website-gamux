ALTER TABLE gamux_project
    DROP COLUMN page_info;

ALTER TABLE gamux_project_page_info
    ADD COLUMN gamux_project_id uuid UNIQUE
    REFERENCES gamux_project (id);