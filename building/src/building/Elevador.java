package building;

import java.util.Scanner;
import java.util.Objects;

public class Elevador {

		private int capacidade;
		private int andares;
		private int andarAtual;
		private int qtdpessoas;
		private Scanner dados;

		@Override
		public String toString() {
			return "Elevador [capacidade=" + capacidade + ", andares=" + andares + ", andarAtual=" + andarAtual
					+ ", qtdpessoas=" + qtdpessoas + ", dados=" + dados + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(andarAtual, andares, capacidade, dados, qtdpessoas);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Elevador other = (Elevador) obj;
			return andarAtual == other.andarAtual && andares == other.andares && capacidade == other.capacidade
					&& Objects.equals(dados, other.dados) && qtdpessoas == other.qtdpessoas;
		}

		public Elevador() {
			super();
			this.dados = new Scanner(System.in);
		}

		public int getCapacidade() {
			return capacidade;
		}

		public void setCapacidade(int capacidade) {
			this.capacidade = capacidade;
		}

		public int getAndares() {
			return andares;
		}

		public void setAndares(int andares) {
			this.andares = andares;
		}

		public int getAndarAtual() {
			return andarAtual;
		}

		public void setAndarAtual(int andarAtual) {
			this.andarAtual = andarAtual;
		}

		public int getQtdPessoas() {
			return qtdpessoas;
		}

		public void setQtdPessoas(int qtdpessoas) {
			this.qtdpessoas = qtdpessoas;
		}

		public void inicializa() {

			System.out.println("Quantos andares tem o predio? ");
			setAndares(dados.nextInt());

			System.out.println("Qual a lota��o do elevador? ");
			setCapacidade(dados.nextInt());

			dados.nextLine();

		}

		public void entra() {

			int newqtd;

			System.out.println("Quantos pessoas vao entrar? ");

			do {
				newqtd = dados.nextInt();
				int qtdTeste = newqtd + getQtdPessoas();

				if (qtdTeste > getCapacidade()) {
					System.out.println("Lota��o Maxima: " + getCapacidade());
					System.out.println("Quantas pessoas vao entrar??");

				} else {
					int testeqtd = this.getQtdPessoas() + newqtd;

					if (testeqtd <= getCapacidade()) {
						this.qtdpessoas = qtdpessoas + newqtd;
						System.out.println("Pessoas no elevador: " + getQtdPessoas());

					} else {
						System.out.println("O elevador nao possui essa quantidade de pessoas!");
					}

				}

			} while (newqtd > getCapacidade());

		}

		public void sai() {

			int pessoas, teste;
			System.out.println("Pessoas no elevador: " + getQtdPessoas());

			System.out.println("Quantos pessoas v�o descer? ");

			do {
				System.out.println("Quantos pessoas v�o descer? ");
				pessoas = dados.nextInt();

				teste = getQtdPessoas() - pessoas;

				if (pessoas <= qtdpessoas) {
					this.qtdpessoas = qtdpessoas - pessoas;
					System.out.println("Pessoas no elevador: " + getQtdPessoas());

				} else {
					System.out.println("Elevador possui " + getQtdPessoas() + " Pessoas.");
					System.out.println("So podem descer essa quantidade de pessoas!!");
				}

			} while (teste < 0);
		}

		public void sobe() {

			int quantidadeSobe;
			int teste;

			System.out.printf("Voce esta no %d� \n", getAndarAtual(), " Andar");

			do {

				System.out.println("Quantos andares deseja subir? ");
				quantidadeSobe = dados.nextInt();

				teste = this.getAndarAtual() + quantidadeSobe;
				if (teste > getAndares()) {
					System.out.println("O predio tem apenas " + getAndares() + " Andares");
				}

			} while (teste > getAndares());

			if (teste <= getAndares()) {

				this.andarAtual = andarAtual + quantidadeSobe;
				System.out.printf("Voce foi para o %d� andar. \n", getAndarAtual(), " Andar");
			}

		}

		public void desce() {

			int quantidadeDesce;
			int teste;

			System.out.printf("Voce esta no %d� \n", getAndarAtual(), " Andar");

			do {
				System.out.println("Quantos andares deseja descer? ");
				quantidadeDesce = dados.nextInt();

				teste = this.getAndarAtual() - quantidadeDesce;

				if (teste >= 0) {
					this.andarAtual = andarAtual - quantidadeDesce;
					System.out.printf("Voce esta no %d� \n", getAndarAtual(), " Andar");
				} else {
					System.out.println("Voce nao pode descer para um andar menor que 0");
					this.andarAtual = 0;
				}

			} while (teste < 0);
	}
}		
