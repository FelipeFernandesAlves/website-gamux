-- Extensão para gerar UUIDs automaticamente (opcional, mas recomendado)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TYPE "project_status" AS ENUM (
  'FINALIZADO',
  'EM_PROGRESSO',
  'CANCELADO'
);

CREATE TYPE "project_type" AS ENUM (
  'JOGO'
);

CREATE TABLE "users" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "username" varchar UNIQUE NOT NULL,
  "name" varchar NOT NULL,
  "email" varchar UNIQUE NOT NULL,
  "avatar" varchar
);

CREATE TABLE "gamux_project_page_info" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "description" text,
  "banner" varchar,
  "external_links" JSONB DEFAULT '{}',
  "bg_color" varchar(7),
  "bg2_color" varchar(7),
  "text_color" varchar(7),
  "link_color" varchar(7),
  "heading_color" varchar(7)
);

CREATE TABLE "gamux_project" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "name" varchar NOT NULL,
  "slug" varchar unique NOT NULL,
  "logo" varchar,
  "description" text,
  "tags" varchar[],
  "page_info" uuid REFERENCES "gamux_project_page_info" ("id") ON DELETE SET NULL,
  "status" project_status DEFAULT 'EM_PROGRESSO',
  "genres" varchar[],
  "type" project_type DEFAULT 'JOGO',
  "created_at" timestamptz DEFAULT now(),
  "last_updated" timestamptz DEFAULT now(),
  "likes" int DEFAULT 0
);

CREATE TABLE "gamux_project_member" (
  "project_id" uuid REFERENCES "gamux_project" ("id") ON DELETE CASCADE,
  "user_id" uuid REFERENCES "users" ("id") ON DELETE CASCADE,
  "role" varchar,
  "joined_at" timestamptz DEFAULT now(),
  PRIMARY KEY ("project_id", "user_id")
);

CREATE TABLE "gamux_project_update" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "project_id" uuid NOT NULL REFERENCES "gamux_project" ("id") ON DELETE CASCADE,
  "title" varchar NOT NULL,
  "content" text,
  "created_at" timestamptz DEFAULT now()
);

CREATE TABLE "gamux_project_comment" (
  "id" uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
  "project_id" uuid NOT NULL REFERENCES "gamux_project" ("id") ON DELETE CASCADE,
  "user_id" uuid NOT NULL REFERENCES "users" ("id") ON DELETE SET NULL,
  "content" text NOT NULL,
  "created_at" timestamptz DEFAULT now()
);