/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package omoikane.nadesicoiLegacy

class ClaveUnidadSat {

    static def asignarA(serv) {
        serv.getClaveUnidadSat = getClaveUnidadSat
//        serv.addClaveUnidadSat = addClaveUnidadSat
//        serv.modClaveUnidadSat = modClaveUnidadSat
    }
    static def getClaveUnidadSat = { clave ->
        def salida = ""
        try {
        def db   = Db.connect()
        def cus = db.firstRow("SELECT * FROM CLAVE_UNIDAD_SAT WHERE clave = $clave")
            db.close()
            salida = cus
        } catch(e) {throw new Exception("Error al consultar clave unidad SAT")}
        salida
    }

//    static def addClaveUnidadSat = {descripcion, descuento ->
//        def db
//        try {
//            db = Db.connect()
//            try {
//                db.connection.autoCommit = false
//                def IDGrupo = db.executeInsert("INSERT INTO grupos SET descripcion = ?, descuento = ?",[descripcion, descuento])
//                IDGrupo = IDGrupo[0][0]
//                db.commit()
//                return "Grupo $descripcion agregada."
//            } catch(Exception e) {
//                db.rollback()
//                if(e.message.contains("Duplicate entry")) { return "El Grupo que intenta capturar ya exíste" }
//                println "[Excepcion:$e]"
//                throw new Exception("Error al enviar a la base de datos. El Grupo no se registró.")
//            } finally {
//                db.close()
//            }
//        } catch(e) { throw new Exception("Error en la conexión del servidor con su base de datos") }
//    }
//
//    static def modClaveUnidadSat = { IDGrupo, descripcion, descuento ->
//        def db   = Db.connect()
//        try {
//          db.connection.autoCommit = false
//          db.executeUpdate("UPDATE grupos SET descripcion = ?, descuento = ? WHERE id_grupo = ?",[descripcion, descuento, IDGrupo])
//          db.commit()
//          return "Grupo modificado existosamente"
//        } catch(Exception e) {
//            db.rollback()
//            println "[Excepcion:$e]"
//            throw new Exception ("Error al modificar Grupo")
//        } finally {
//            db.close()
//        }
//    }

}

