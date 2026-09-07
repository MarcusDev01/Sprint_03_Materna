
# Materna+

Aplicativo Android (MVP navegável) desenvolvido para a Sprint 3 da disciplina, com dados mockados representando o funcionamento da plataforma de doação de leite materno proposta nas Sprints anteriores.

## Objetivo da entrega (Sprint 3)

Esta entrega corresponde ao objetivo definido para a Sprint 3: desenvolver uma versão funcional do aplicativo Android em Kotlin, transformando a proposta apresentada no pitch em um **MVP navegável, estruturado e demonstrável**, com as principais telas e fluxos do produto, utilizando **dados mockados** para simular o funcionamento da aplicação.

O foco desta etapa foi:
- Construção da aplicação Android em Kotlin (Jetpack Compose).
- Organização do código em camadas (`model`, `mock`, `navigation`, `ui`).
- Navegação entre todas as telas principais do produto.
- Apresentação dos dados mockados (doadoras e bancos de leite).
- Coerência entre a solução proposta no pitch e as funcionalidades implementadas.

**Fora do escopo desta Sprint** (conforme enunciado): não há integração com API, Firebase, banco de dados local ou backend. Todos os dados exibidos são estáticos, definidos em `mock/MockDoadoras.kt` e `mock/MockBancos.kt`.

## Equipe

Materna+

- Enzo Wakao — RM 556635
- Henry Vinicius Titotto Gonçalves — RM 555421
- João Pedro Thamer Perin — RM 555367
- Lucas Furquim de Campos Roma — RM 556155
- Marcus Vinicius Martinho Lucas — RM 554616

## Objetivo do aplicativo

O Materna+ ajuda nutrizes a se cadastrarem como doadoras de leite materno, encontrarem bancos de leite humano próximos e tirarem dúvidas sobre o processo de doação através de um assistente de atendimento, endereçando o baixo percentual de demanda suprida no Brasil (~55%) apresentado no pitch do projeto.

## Link do repositório

https://github.com/MarcusDev01/Sprint_03_Materna

## Telas do aplicativo
<img width="1206" height="599" alt="{E6E0740D-47D1-4FFE-A045-2AE55290C77B}" src="https://github.com/user-attachments/assets/21ef23cf-3a7e-4015-958a-9b9627ca8bdb" />
<img width="1019" height="585" alt="{E6B20DB4-4142-4F14-844A-9EFFBA88ABA1}" src="https://github.com/user-attachments/assets/8d90ef26-f6e0-40c8-acec-67ba79e73368" />
<img width="1048" height="620" alt="{212C6E8B-BCB0-4A85-9F82-3FBA89C14FCD}" src="https://github.com/user-attachments/assets/3ec20612-c280-4eba-ba65-0ae2cfb1b6ac" />
<img width="1206" height="606" alt="{81DD4B8C-E9F5-4D8F-BEF0-517237AC942C}" src="https://github.com/user-attachments/assets/f1264ce5-9c35-48c5-8b2b-cc7bc076924d" />
<img width="1221" height="617" alt="{50089B9C-B246-468E-96CB-8D62671E0FA3}" src="https://github.com/user-attachments/assets/4203ade1-c729-4d7d-b7f6-a08fbd83c82d" />










| Tela | Descrição |
|---|---|
| Início | Tela de apresentação do app, com acesso rápido às doadoras, bancos de leite e ao assistente. |
| Doadoras cadastradas | Lista as nutrizes doadoras mockadas, com nome, cidade e status de doação. |
| Detalhes da doadora | Exibe idade, cidade, banco de leite vinculado, litros doados e status ao tocar em uma doadora da lista. |
| Cadastro de doadora | Formulário para registrar uma nova nutriz doadora (nome, idade, cidade). |
| Bancos de leite | Lista os bancos de leite humano mockados disponíveis para doação/exames. |
| Detalhes do banco | Exibe endereço, horário de funcionamento, telefone e se o banco realiza exames. |
| Assistente Materna+ | Chatbot simulado que responde dúvidas comuns sobre doação, cadastro e exames. |

## Funcionalidades implementadas

- Navegação completa entre as 7 telas descritas acima, com passagem de parâmetros (id da doadora e id do banco) da listagem para o detalhe.
- Listagem e detalhamento de doadoras e de bancos de leite a partir de dados mockados.
- Formulário de cadastro de doadora com validação básica de campos.
- Chatbot com respostas simuladas por palavra-chave.

### Coerência com a proposta do pitch

O MVP cobre os três pilares apresentados no pitch das Sprints anteriores: (1) cadastro de nutrizes como doadoras, (2) localização de bancos de leite humano e (3) suporte a dúvidas via assistente — sem, nesta etapa, depender de nenhuma fonte de dados externa.

## Dados mockados

Os dados estão organizados em `model` (classes `Doadora`, `BancoDeLeite`, `MensagemChat`) e `mock` (`MockDoadoras`, `MockBancos`), evitando dados soltos nas telas. Representam nutrizes e bancos de leite fictícios, mas com informações realistas (cidades da região de São Paulo, litros doados, horários de funcionamento).

## Tecnologias utilizadas

- Kotlin
- Jetpack Compose + Material 3
- Navigation Compose
- Android Studio

## Estrutura do projeto

```
app/src/main/java/com/example/materna
├── model         # classes de dados (Doadora, BancoDeLeite, MensagemChat)
├── mock          # listas de dados mockados
├── navigation    # rotas (Screen) e grafo de navegação (NavGraph)
├── ui/theme      # cores, tipografia e tema do Compose
├── ui/components # componentes reutilizáveis (cards, top bar)
├── ui/screens    # telas do app
└── MainActivity.kt
```

## Como executar o projeto

1. Abrir a pasta `Sprint_03_Materna` no Android Studio.
2. Aguardar a sincronização do Gradle (o wrapper já está incluído no projeto).
3. Selecionar um emulador ou dispositivo físico com Android 7.0 (API 24) ou superior.
4. Rodar o app com o botão **Run** (▶).

### Dependências relevantes

- `androidx.navigation:navigation-compose`
- `androidx.compose:compose-bom`
- `androidx.compose.material3:material3`
- `androidx.compose.material:material-icons-core`

## Histórico de commits desta sprint

O código foi versionado em 3 commits organizados por camada:

1. **Modelos e dados mockados** — `model/` e `mock/`.
2. **Tema e componentes de UI** — `ui/theme/`, `ui/components/` e `navigation/Screen.kt`.
3. **Telas e integração de navegação** — `ui/screens/`, `navigation/NavGraph.kt` e `MainActivity.kt`.
