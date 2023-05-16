enum class Level { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Level) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
       inscritos.add(usuario)
    }
    
    fun imprimirListaInscritos(){
        for(user in inscritos){
        println(user.nome)
    }
}

    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")


//cursos individuais
    val moduloJava = ConteudoEducacional("curso java", 120)
    val moduloKotlin = ConteudoEducacional("curso kotlin", 60)

    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(moduloJava)
    listConteudos.add(moduloKotlin)

    //formação completa com todos os cursos
    val formacaoAndroid = Formacao("Formação Android Developer", listConteudos, Level.INTERMEDIARIO)

    //Criar lista de usuarios
    val wander = Usuario("Wander", "wander@gmail.com")
    val ana = Usuario("Ana", "ana@gmail.com")

    //matricula dos usuarios na formação
    formacaoAndroid.matricular(wander)
    formacaoAndroid.matricular(ana)

    println("======================================")
    println("Dados da formação")
    println("${formacaoAndroid.nome} - ${formacaoAndroid.nivel}")
    println("Grade formação")
    println(formacaoAndroid.imprimirGradeFormacao())
    println("=======================================")
    println("Lista de inscritos")
    println(formacaoAndroid.imprimirListaInscritos())
}