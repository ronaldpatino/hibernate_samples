CREATE TABLE "mensaje" (
  "id"                    INT8 NOT NULL DEFAULT nextval('mensaje_id_seq' :: REGCLASS),
  "identificador"         VARCHAR(10) COLLATE "default",
  "mensaje"               VARCHAR(255) COLLATE "default",
  "informacion_adicional" TEXT COLLATE "default",
  "tipo"                  VARCHAR(10) COLLATE "default",
  "respuesta_id"          INT8,
  CONSTRAINT "mensaje_pkey" PRIMARY KEY ("id")
);

CREATE INDEX "fk_respuesta_id" ON "mensaje" ("respuesta_id" ASC);

CREATE TABLE "respuesta" (
  "id"                   INT8 NOT NULL DEFAULT nextval('respuesta_id_seq' :: REGCLASS),
  "codigo_documento_sri" VARCHAR(2) COLLATE "default",
  "codigo_local"         VARCHAR(3) COLLATE "default",
  "codigo_punto_venta"   VARCHAR(3) COLLATE "default",
  "numero_factura"       VARCHAR(9) COLLATE "default",
  "clave_acceso"         VARCHAR(49) COLLATE "default",
  "numero_autorizacion"  VARCHAR(32) COLLATE "default",
  "resultado"            VARCHAR(20) COLLATE "default",
  "ambiente"             VARCHAR(1) COLLATE "default",
  "id_factura"           VARCHAR(20) COLLATE "default",
  "fecha"                VARCHAR(40) COLLATE "default",
  CONSTRAINT "respuesta_pkey" PRIMARY KEY ("id")
);


ALTER TABLE "mensaje" ADD CONSTRAINT "fk_respuesta_id" FOREIGN KEY ("respuesta_id") REFERENCES "respuesta" ("id");

CREATE OR REPLACE VIEW "public"."respuestas" AS
  SELECT
    "public".respuesta.codigo_documento_sri,
    "public".respuesta.codigo_local,
    "public".respuesta.codigo_punto_venta,
    "public".respuesta.numero_factura,
    "public".respuesta.clave_acceso,
    "public".respuesta.numero_autorizacion,
    "public".respuesta.resultado,
    "public".respuesta.ambiente,
    "public".mensaje.identificador,
    "public".mensaje.mensaje,
    "public".mensaje.informacion_adicional,
    "public".mensaje.tipo,
    "public".respuesta."id",
    "public".respuesta.fecha,
    "public".respuesta.id_factura,
    "public".mensaje.fecha
  FROM (mensaje
    JOIN respuesta ON ((mensaje.respuesta_id = respuesta.id)))
  ORDER BY respuesta.fecha DESC;

