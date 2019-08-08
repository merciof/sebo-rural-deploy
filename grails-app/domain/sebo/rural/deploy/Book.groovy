package sebo.rural.deploy

class Book {

    String titulo
    String autor
    String descricao
    String urlFoto
    String curso
    String periodo
    String disciplina
    String preco
    Date dataCriacaoAnuncio

    static constraints = {
      titulo nullable : true
      autor nullable : true
      descricao nullable : true
      urlFoto nullable : true
      curso nullable : true
      periodo nullable : true
      disciplina nullable : true
      //student nullable: true
      preco nullable: true
      dataCriacaoAnuncio nullable: true
    }
}
