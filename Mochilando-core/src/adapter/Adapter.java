/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domainJPA.Atracao;
import model.domainJPA.Cidade;
import model.domainJPA.Dia;
import model.domainJPA.Diario;
import model.domainJPA.Estado;
import model.domainJPA.Foto;
import model.domainJPA.Tag;
import model.domainJPA.TagDiario;
import model.domainJPA.TipoAtracao;
import model.domainJPA.Usuario;
import model.domainJPA.UsuarioTag;
import model.serviceJPA.Impl.*;
import model.serviceJPA.interfaces.*;
import util.db.exception.ExcecaoConexaoCliente;
import util.service.ExcecaoNegocio;
import util.db.exception.ExcecaoPersistencia;

/**
 *
 * @author Juliana Carvalho de Souza, Carlos Henrique Brasileiro
 */

/*
    Esta classse e responsavel por tratar o arraylist vindo e retornar para o cliente
 */
public class Adapter implements Runnable {

    //Este socket sera utilizado para mandar pacotes ao cliente
    private DatagramSocket adapterDatagramaSocket;
    
    private static final int TAMANHO_MAXIMO_DATAGRAMA_UDP = 65507;
    private final ArrayList requisicao;
    private ArrayList resposta;

    //Vetor de bytes a ser enviado para o cliente
    private byte[] vetorBytesDestinoCliente = new byte[TAMANHO_MAXIMO_DATAGRAMA_UDP];

    //Vetor de bytes a ser recebido do cliente
    private byte[] vetorBytesVindoCliente = new byte[TAMANHO_MAXIMO_DATAGRAMA_UDP];

    

    //Endereco IP do cliente (usado para mandar resposta)
    InetAddress enderecoIPCliente;

    //Porta do cliente (usado para mandar resposta)
    int portaCliente;
    
    public Adapter(ArrayList requisicao, InetAddress enderecoIPCliente, int portaCliente){
        
        this.requisicao = requisicao;
        this.enderecoIPCliente =  enderecoIPCliente;
        this.portaCliente = portaCliente;
    }
/*
    public Adapter(DatagramPacket datagramaReceber) throws IOException, ClassNotFoundException {
        //
            Construtor responsavel por inicializar variaveis de pacote
        //
        
        //Pegando dados do pacote
        vetorBytesVindoCliente = datagramaReceber.getData();

        //Pegando tamanho do pacote
        tamanhoPacoteEmBytes = datagramaReceber.getLength();

        //Pegando endereco IP do cliente
        enderecoIPCliente = datagramaReceber.getAddress();

        //Pegando porta do cliente
        portaCliente = datagramaReceber.getPort();

        System.out.println("Mensagem recebida do cliente de endereco IP: " + enderecoIPCliente + " por meio da porta: " + portaCliente);

        ObjectInputStream ois;
        try (
                //Convertendo vetor de bytes para arraylist
                ByteArrayInputStream bais = new ByteArrayInputStream(vetorBytesVindoCliente)) {
            ois = new ObjectInputStream(bais);
            this.requisicao = (ArrayList) ois.readObject();
        }
        ois.close();

        //O construtor deixa o arraylist requisicao pronto para ser tratado
    }
*/
    public void tratarRequisicao() throws ExcecaoPersistencia, ExcecaoNegocio, IOException, ExcecaoConexaoCliente {
        String tipoObjeto = (String) requisicao.get(0);
        String operacao;

        switch (tipoObjeto) {
            case "Usuario":
                InterfaceManterUsuario manterUsuario = new ManterUsuario();
                operacao = (String) requisicao.get(1);

                if (operacao.equals("cadastrar")) {
                    Usuario usr = (Usuario) requisicao.get(2);
                    Long codUsr = manterUsuario.cadastrar(usr);
                    //Enviando somente o valor de codUsuario; 
                    //nao precisa de passar o nome do parametro pois o cliente ja sabe o que espera
                    if (resposta == null) {
                        resposta.add(codUsr);
                    }

                } else if (operacao.equals("alterar")) {
                    Usuario usr = (Usuario) requisicao.get(2);
                    boolean sucesso = manterUsuario.alterar(usr);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }

                } else if (operacao.equals("excluir")) {
                    Usuario usr = (Usuario) requisicao.get(2);
                    boolean sucesso = manterUsuario.excluir(usr);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }

                } else if (operacao.equals("pesquisarTodos")) {
                    List<Usuario> result = manterUsuario.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(result);
                    }

                } else if (operacao.equals("pesquisarPorId")) {
                    Long id = (Long) requisicao.get(2);
                    Usuario result = manterUsuario.pesquisarPorId(id);
                    if (resposta == null) {
                        resposta.add(result);
                    }

                } else if (operacao.equals("getUserLogin")) {
                    String email = (String) requisicao.get(2);
                    System.out.println("Email recebido: "+email);
                    String senha = (String) requisicao.get(3);
                    System.out.println("Senha recebida: "+senha);
                    Usuario result = manterUsuario.getUserLogin(email, senha);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("getUserEmail")) {
                    String email = (String) requisicao.get(2);
                    Usuario result = manterUsuario.getUserEmail(email);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } 
                break;
                
            case "UsuarioTag":
                InterfaceManterUsuarioTag manterUsuarioTag = new ManterUsuarioTag();
                operacao = (String) requisicao.get(1);
                
                if (operacao.equals("cadastrar")) {
                    UsuarioTag usrTag = (UsuarioTag) requisicao.get(2);
                    Long codUsrTag = manterUsuarioTag.cadastrar(usrTag);
                    if (resposta == null) {
                        resposta.add(codUsrTag);
                    }

                } else if (operacao.equals("alterar")) {
                    UsuarioTag usrTag = (UsuarioTag) requisicao.get(2);
                    boolean sucesso = manterUsuarioTag.alterar(usrTag);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }

                } else if (operacao.equals("excluir")) {
                    UsuarioTag usrTag = (UsuarioTag) requisicao.get(2);
                    boolean sucesso = manterUsuarioTag.excluir(usrTag);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }
                } else if (operacao.equals("pesquisarPorId")) {
                    Long id = (Long) requisicao.get(2);
                    UsuarioTag result = manterUsuarioTag.pesquisarPorId(id);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarTodos")) {
                    List<UsuarioTag> sucesso = manterUsuarioTag.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }
                } else if (operacao.equals("pesquisarPorCodUsuario")) {
                    Long codUsuario = (Long) requisicao.get(2); 
                    List<UsuarioTag> result = manterUsuarioTag.pesquisarPorCodUsuario(codUsuario);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarPorCodTag")) {
                    Long codTag = (Long) requisicao.get(2); 
                    List<UsuarioTag> result = manterUsuarioTag.pesquisarPorCodTag(codTag);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }
                
                break;
                
            case "TipoAtracao":
                InterfaceManterTipoAtracao manterTipoAtracao = new ManterTipoAtracao();
                operacao = (String) requisicao.get(1);
                
                if (operacao.equals("cadastrar")) {
                    TipoAtracao tipoAtr = (TipoAtracao) requisicao.get(2);
                    Long codTipoAtr = manterTipoAtracao.cadastrar(tipoAtr);
                    if (resposta == null) {
                        resposta.add(codTipoAtr);
                    }
                } else if (operacao.equals("alterar")) {
                   TipoAtracao tipoAtr = (TipoAtracao) requisicao.get(2);
                   boolean sucesso = manterTipoAtracao.alterar(tipoAtr);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("excluir")) {
                   TipoAtracao tipoAtr = (TipoAtracao) requisicao.get(2);
                   boolean sucesso = manterTipoAtracao.excluir(tipoAtr);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("pesquisarPorId")) {
                   Long codTipoAtr = (Long) requisicao.get(2);
                   TipoAtracao result = manterTipoAtracao.pesquisarPorId(codTipoAtr);
                    if (resposta == null) {
                        resposta.add(result);
                    } 
                } else if (operacao.equals("pesquisarPorNome")) {
                   String descTipoAtracao = (String) requisicao.get(2);
                   TipoAtracao sucesso = manterTipoAtracao.pesquisarPorNome(descTipoAtracao);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("pesquisarTodos")) {
                   List<TipoAtracao> sucesso = manterTipoAtracao.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                }
                               
                break;
                
            case "TagDiario":
                InterfaceManterTagDiario manterTagDiario = new ManterTagDiario();
                operacao = (String) requisicao.get(1); 
                
                if (operacao.equals("cadastrar")) {
                    TagDiario codTagDiario = (TagDiario) requisicao.get(2);
                    Long tagDiario = manterTagDiario.cadastrar(codTagDiario);
                    if (resposta == null) {
                        resposta.add(tagDiario);
                    }
                } else if (operacao.equals("alterar")) {
                    TagDiario tagDiario = (TagDiario) requisicao.get(2);
                    boolean sucesso = manterTagDiario.alterar(tagDiario);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }
                } else if (operacao.equals("excluir")) {
                    TagDiario tagDiario = (TagDiario) requisicao.get(2);
                    boolean sucesso = manterTagDiario.excluir(tagDiario);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }
                } else if (operacao.equals("pesquisarPorId")) {
                    Long seqTagDiario = (Long) requisicao.get(2);
                    TagDiario result = manterTagDiario.pesquisarPorId(seqTagDiario);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarTodos")) {
                    List<TagDiario> sucesso = manterTagDiario.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }
                } else if (operacao.equals("pesquisarPorCodDiario")) {
                    Long codDiario = (Long) requisicao.get(2);
                    List<TagDiario> result = manterTagDiario.pesquisarPorCodDiario(codDiario);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarPorCodTag")) {
                    Long codTag = (Long) requisicao.get(2);
                    List<TagDiario> result = manterTagDiario.pesquisarPorCodTag(codTag);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }
                
                break;
                
            case "Tag":
                InterfaceManterTag manterTag = new ManterTag();
                operacao = (String) requisicao.get(1); 
                
                if (operacao.equals("cadastrar")) {
                    Tag tag = (Tag) requisicao.get(2);
                    Long codTag = manterTag.cadastrar(tag);
                    if (resposta == null) {
                        resposta.add(codTag);
                    }
                } else if (operacao.equals("alterar")) {
                    Tag tag = (Tag) requisicao.get(2);
                    boolean sucesso = manterTag.alterar(tag);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }
                } else if (operacao.equals("excluir")) {
                    Tag tag = (Tag) requisicao.get(2);
                    boolean sucesso = manterTag.excluir(tag);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    }
                } else if (operacao.equals("pesquisarPorId")) {
                    Long codTag = (Long) requisicao.get(2);
                    Tag result = manterTag.pesquisarPorId(codTag);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarPorNome")) {
                    String descTag = (String) requisicao.get(2);
                    Tag result = manterTag.pesquisarPorNome(descTag);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }

                break;
                
            case "Atracao":
                InterfaceManterAtracao manterAtracao = new ManterAtracao();
                operacao = (String) requisicao.get(1);

                if (operacao.equals("cadastrar")) {
                    Atracao atr = (Atracao) requisicao.get(2);
                    Long codAtr = manterAtracao.cadastrar(atr);
                    if (resposta == null) {
                        resposta.add(codAtr);
                    }
                } else if (operacao.equals("alterar")) {
                    Atracao atr = (Atracao) requisicao.get(2);
                    boolean sucesso = manterAtracao.alterar(atr);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("excluir")) {
                    Atracao atr = (Atracao) requisicao.get(2);
                    boolean sucesso = manterAtracao.excluir(atr);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("pesquisarPorId")) {
                   Long id = (Long) requisicao.get(2);
                   Atracao result = manterAtracao.pesquisarPorId(id);
                    if (resposta == null) {
                        resposta.add(result);
                    } 
                } else if (operacao.equals("pesquisarPorCodCidade")) {
                   Long codCidade = (Long) requisicao.get(2);
                   List<Atracao> result = manterAtracao.pesquisarPorCodCidade(codCidade);
                    if (resposta == null) {
                        resposta.add(result);
                    } 
                } else if (operacao.equals("pesquisarPorCodEstado")) {
                   Long codEstado = (Long) requisicao.get(2);
                   List<Atracao> result = manterAtracao.pesquisarPorCodEstado(codEstado);
                    if (resposta == null) {
                        resposta.add(result);
                    } 
                } else if (operacao.equals("pesquisarPorCodTipoAtracao")) {
                   Long codTipoAtracao = (Long) requisicao.get(2);
                   List<Atracao> result = manterAtracao.pesquisarPorCodTipoAtracao(codTipoAtracao);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarTodos")) {
                   List<Atracao> result = manterAtracao.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }
                break;
                
            
             
            case "Cidade":
                InterfaceManterCidade manterCidade = new ManterCidade();
                operacao = (String) requisicao.get(1);
                
                if (operacao.equals("cadastrar")) {
                    Cidade cid = (Cidade) requisicao.get(2);
                    Long cidade = manterCidade.cadastrar(cid);
                    if (resposta == null) {
                        resposta.add(cidade);
                    }
                } else if (operacao.equals("alterar")) {
                   Cidade cid = (Cidade) requisicao.get(2);
                   boolean sucesso = manterCidade.alterar(cid);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("excluir")) {
                   Cidade cid = (Cidade) requisicao.get(2);
                   boolean sucesso = manterCidade.excluir(cid);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("pesquisarPorId")) {
                   Long codCidade = (Long) requisicao.get(2);
                   Cidade result = manterCidade.pesquisarPorId(codCidade);
                    if (resposta == null) {
                        resposta.add(result);
                    } 
                } else if (operacao.equals("pesquisarPorCodEstado")) {
                   Long codEstado = (Long) requisicao.get(2);
                   List<Cidade> result = manterCidade.pesquisarPorCodEstado(codEstado);
                    if (resposta == null) {
                        resposta.add(result);
                    } 
                } else if (operacao.equals("pesquisarTodos")) {
                   List<Cidade> result = manterCidade.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(result);
                    } 
                }
                break;
                
            
                
            case "Dia": 
                InterfaceManterDia manterDia = new ManterDia();
                operacao = (String) requisicao.get(1);
                
                if (operacao.equals("cadastrar")) {
                    Dia dDia = (Dia) requisicao.get(2);
                    Long dia = manterDia.cadastrar(dDia);
                    if (resposta == null) {
                        resposta.add(dia);
                    }
                } else if (operacao.equals("alterar")) {
                   Dia dia = (Dia) requisicao.get(2);
                   boolean sucesso = manterDia.alterar(dia);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("excluir")) {
                   Dia dia = (Dia) requisicao.get(2);
                   boolean sucesso = manterDia.excluir(dia);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("pesquisarPorId")) {
                   Long seqDia = (Long) requisicao.get(2);
                   Dia result = manterDia.pesquisarPorId(seqDia);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarPorCodDiario")) {
                   Long codDiario = (Long) requisicao.get(2);
                   List<Dia> result = manterDia.pesquisarPorCodDiario(codDiario);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarTodos")) {
                   List<Dia> result = manterDia.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }
                break;
                
            
                
            case "Diario": 
                InterfaceManterDiario manterDiario = new ManterDiario();
                operacao = (String) requisicao.get(1);
                
                if (operacao.equals("cadastrar")) {
                    Diario dir = (Diario) requisicao.get(2);
                    Long diario = manterDiario.cadastrar(dir);
                    if (resposta == null) {
                        resposta.add(diario);
                    }
                } else if (operacao.equals("alterar")) {
                   Diario diario = (Diario) requisicao.get(2);
                   boolean sucesso = manterDiario.alterar(diario);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("excluir")) {
                   Diario diario = (Diario) requisicao.get(2);
                   boolean sucesso = manterDiario.excluir(diario);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("pesquisarPorId")) {
                   Long codDiario = (Long) requisicao.get(2);
                   Diario result = manterDiario.pesquisarPorId(codDiario);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarTodos")) {
                   List<Diario> result = manterDiario.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarPorCodUsuario")) {
                   Long codUsuario = (Long) requisicao.get(2);
                   List<Diario> result = manterDiario.pesquisarPorCodUsuario(codUsuario);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarPorCodCidade")) {
                   Long codCidade = (Long) requisicao.get(2);
                   List<Diario> result = manterDiario.pesquisarPorCodCidade(codCidade);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarPorCodEstado")) {
                   Long codEstado = (Long) requisicao.get(2);
                   List<Diario> result = manterDiario.pesquisarPorCodEstado(codEstado);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }else if (operacao.equals("atualizarPagInicial")) {
                   Long codUsuario = (Long) requisicao.get(2);
                   List<Diario> result = manterDiario.atualizarPagInicial(codUsuario);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }else if (operacao.equals("pesquisarDiario")) {
                   String textoBusca = (String) requisicao.get(2);
                   List<Diario> result = manterDiario.pesquisarDiario(textoBusca);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }
                break;
                
            case "Estado": 
                InterfaceManterEstado manterEstado = new ManterEstado();
                operacao = (String) requisicao.get(1);
                
                if (operacao.equals("cadastrar")) {
                    Estado est = (Estado) requisicao.get(2);
                    Long estado = manterEstado.cadastrar(est);
                    if (resposta == null) {
                        resposta.add(estado);
                    }
                } else if (operacao.equals("alterar")) {
                   Estado est = (Estado) requisicao.get(2);
                   boolean sucesso = manterEstado.alterar(est);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("excluir")) {
                   Estado est = (Estado) requisicao.get(2);
                   boolean sucesso = manterEstado.excluir(est);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("pesquisarPorId")) {
                   Long codEstado = (Long) requisicao.get(2);
                   Estado result = manterEstado.pesquisarPorId(codEstado);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarPorSigla")) {
                   String sigla = (String) requisicao.get(2);
                   Estado result = manterEstado.pesquisarPorSigla(sigla);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarTodos")) {
                   List<Estado> result = manterEstado.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }
                break;
                
            case "Foto": 
                InterfaceManterFoto manterFoto = new ManterFoto();
                operacao = (String) requisicao.get(1);
                
                if (operacao.equals("cadastrar")) {
                    Foto vFoto = (Foto) requisicao.get(2);
                    Long foto = manterFoto.cadastrar(vFoto);
                    if (resposta == null) {
                        resposta.add(foto);
                    }
                } else if (operacao.equals("alterar")) {
                   Foto foto = (Foto) requisicao.get(2);
                   boolean sucesso = manterFoto.alterar(foto);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("excluir")) {
                   Foto foto = (Foto) requisicao.get(2);
                   boolean sucesso = manterFoto.excluir(foto);
                    if (resposta == null) {
                        resposta.add(sucesso);
                    } 
                } else if (operacao.equals("pesquisarPorId")) {
                   Long seqFoto = (Long) requisicao.get(2);
                   Foto result = manterFoto.pesquisarPorId(seqFoto);
                    if (resposta == null) {
                        resposta.add(result);
                    }
                } else if (operacao.equals("pesquisarTodos")) {
                   List<Foto> result = manterFoto.pesquisarTodos();
                    if (resposta == null) {
                        resposta.add(result);
                    }
                }
                break;
        }
        //Apos escrever no arrayList, envia a resposta
        enviarResposta();
    }

    public void enviarResposta() throws IOException {
        //Converte arraylis para bytes

        ByteArrayOutputStream baos;
        ObjectOutputStream writer = null;

        baos = new ByteArrayOutputStream();

        try {
            writer = new ObjectOutputStream(baos);
            writer.writeObject(resposta);
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        vetorBytesDestinoCliente = baos.toByteArray();

        //Finalmente envia para o servidor
        DatagramPacket datagramaEnviar;
        datagramaEnviar = new DatagramPacket(vetorBytesDestinoCliente, vetorBytesDestinoCliente.length, enderecoIPCliente, portaCliente);
        adapterDatagramaSocket.send(datagramaEnviar);

    }

    @Override
    public void run() {
        try {
            tratarRequisicao();

        } catch (ExcecaoPersistencia | ExcecaoNegocio | IOException | ExcecaoConexaoCliente ex  ) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
