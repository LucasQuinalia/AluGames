package br.com.alura.alugames.dados

import javax.persistence.*

@Entity
@Table(name = "gamers")

class GamerEntity(
    val nome: String = "Nome do gamer",
    val email: String = "Email do gamer",
    val dataNascimento: String? = null,
    val usuario: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()) {
}
