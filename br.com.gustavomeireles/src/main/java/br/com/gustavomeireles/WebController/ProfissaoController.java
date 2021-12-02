package br.com.gustavomeireles.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gustavomeireles.domain.Empresa;
import br.com.gustavomeireles.domain.Profissao;
import br.com.gustavomeireles.service.EmpresaService;
import br.com.gustavomeireles.service.ProfissaoService;


@Controller
@RequestMapping("/profissoes")
public class ProfissaoController {
        @Autowired
		private ProfissaoService profissaoService;
        @Autowired
        private EmpresaService empresaService;
        
        
		@GetMapping("cadastrar")
		public String cadastrar(Profissao profissao) {
			return "/profissao/cadastro";
		}
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("profissoes",profissaoService.buscarTodos());
		return"/profissao/lista";
	}
	@PostMapping("/salvar")
	public String Salvar(Profissao profissao, RedirectAttributes attr){
		
		attr.addFlashAttribute("success", "profissao inserida com sucesso");
		profissaoService.salvar(profissao);
		return "redirect:/profissoes/cadastrar";
		
	}
	@ModelAttribute("empresas")
	public List<Empresa> listaDeEmpresa(){
		return empresaService.buscarTodos();
	}
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id")Long id,ModelMap model) {
		model.addAttribute("profissao", profissaoService.buscarPorId(id));
		return"/profissoes/cadastro";
	}
		@PostMapping("/editar")
		public String editar(Profissao profissao, RedirectAttributes attr) {
			attr.addFlashAttribute("success", "profissao alterada com sucesso");
			profissaoService.editar(profissao);
			
			return "redirect:/profissoes/cadastrar"; 
		}
		
		@GetMapping("/excluir/{id}")
		public String excluir(@PathVariable("id")Long id,ModelMap model) {
			if(profissaoService.profissaoTemCliente(id)) {
				model.addAttribute("fail", "profissao nao removida .Possui profissao(s) vinculado(s)"); 
				
			}else {
				profissaoService.excluir(id);
				model.addAttribute("success", "Profissao excluida com sucesso");
			}
			return listar(model);
			}
	}

