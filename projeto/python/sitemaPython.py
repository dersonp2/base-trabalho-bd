import psycopg2

def conectar():
    return psycopg2.connect(
        host="localhost",
        database="usuario",
        user="postgres",
        password="root"
    )

def salvar(nome, email):
    conn = conectar()
    cursor = conn.cursor()

    sql = "INSERT INTO usuarios (nome, email) VALUES (%s, %s)"
    cursor.execute(sql, (nome, email))

    conn.commit()
    cursor.close()
    conn.close()

    print("Usuário cadastrado!")


def listar():
    conn = conectar()
    cursor = conn.cursor()

    cursor.execute("SELECT * FROM usuarios")
    usuarios = cursor.fetchall()

    print("\n📋 Lista de Usuários:")
    for u in usuarios:
        print(f"ID: {u[0]} | Nome: {u[1]} | Email: {u[2]}")

    cursor.close()
    conn.close()


def atualizar(id, nome, email):
    conn = conectar()
    cursor = conn.cursor()

    sql = "UPDATE usuarios SET nome=%s, email=%s WHERE id=%s"
    cursor.execute(sql, (nome, email, id))

    conn.commit()
    cursor.close()
    conn.close()

    print("Usuário atualizado!")


def deletar(id):
    conn = conectar()
    cursor = conn.cursor()

    cursor.execute("DELETE FROM usuarios WHERE id=%s", (id,))

    conn.commit()
    cursor.close()
    conn.close()

    print("Usuário removido!")


def buscar_por_nome(nome):
    conn = conectar()
    cursor = conn.cursor()

    cursor.execute("SELECT * FROM usuarios WHERE nome ILIKE %s", (f"%{nome}%",))
    resultados = cursor.fetchall()

    for u in resultados:
        print(f"ID: {u[0]} | Nome: {u[1]} | Email: {u[2]}")

    cursor.close()
    conn.close()


def buscar_por_email(email):
    conn = conectar()
    cursor = conn.cursor()

    cursor.execute("SELECT * FROM usuarios WHERE email ILIKE %s", (f"%{email}%",))
    resultados = cursor.fetchall()

    for u in resultados:
        print(f"ID: {u[0]} | Nome: {u[1]} | Email: {u[2]}")

    cursor.close()
    conn.close()

def menu():
    while True:
        print("\n=== SISTEMA DE USUÁRIOS ===")
        print("1 - Cadastrar")
        print("2 - Listar")
        print("3 - Atualizar")
        print("4 - Deletar")
        print("5 - Buscar por nome")
        print("6 - Buscar por email")
        print("0 - Sair")

        op = input("Escolha: ")

        if op == "1":
            nome = input("Nome: ")
            email = input("Email: ")
            salvar(nome, email)

        elif op == "2":
            listar()

        elif op == "3":
            id = input("ID: ")
            nome = input("Novo nome: ")
            email = input("Novo email: ")
            atualizar(id, nome, email)

        elif op == "4":
            id = input("ID: ")
            deletar(id)

        elif op == "5":
            nome = input("Nome: ")
            buscar_por_nome(nome)

        elif op == "6":
            email = input("Email: ")
            buscar_por_email(email)

        elif op == "0":
            print("Encerrando...")
            break

        else:
            print("Opção inválida!")


menu()