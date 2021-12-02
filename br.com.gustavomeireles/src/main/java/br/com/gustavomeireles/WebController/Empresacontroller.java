package br.com.gustavomeireles.WebController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gustavomeireles.domain.Empresa;
import br.com.gustavomeireles.service.EmpresaService;



@Controller
@RequestMapping("/empresas")
public class Empresacontroller {
	
	private EmpresaService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar() { 
		return "/empresa/cadastro";
	}
@GetMapping("/listar")
public String listar(ModelMap model){
	model.addAttribute("empresas", service.buscarTodos());
	return"/empresa/lista";
}
@PostMapping("/salvar")
public String Salvar(Empresa empresa, RedirectAttributes attr){
	
	attr.addFlashAttribute("success", "empresa salva com sucesso");
	service.salvar(empresa);
	return "redirect:/empresas/cadastrar";
	
}

@GetMapping("/editar/{id}")
public String preEditar(@PathVariable("id")Long id,ModelMap model) {
	model.addAttribute("empresa", service.buscarPorId(id));
	return"/empresa/cadastro";
}
	@PostMapping("/editar")
	public String editar(Empresa empresa, RedirectAttributes attr) {
		attr.addFlashAttribute("success", "empresa alterado com sucesso");
		service.editar(empresa);
		
		return "redirect:/empresas/cadastrar"; 
	}
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id,ModelMap model) {
		if(service.empresaTemProfissoes(id)) {
			model.addAttribute("fail", "Empresa nao removida .Possui Profissao(s) vinculado(s)"); 
			
		}else {
			service.excluir(id);
			model.addAttribute("success", "Empresa excluida com sucesso");
		}
		return listar(model);
		}
	
	}
	



