package github.lukaszwlod.rental.Controller;

import github.lukaszwlod.rental.model.Client;
import github.lukaszwlod.rental.model.Rental;
import github.lukaszwlod.rental.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientController {

   private ClientService clientService;


   @Autowired
   public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/showAll")
    public String showClients(Model model){

        this.addAttributes(model);
        List<Client> clients = clientService.getClients();

        Rental rental = new Rental();
        System.out.println(rental.toString());



        return "client";
    }

    @PostMapping("/addNew")
    public String addClient(@ModelAttribute("client") Client client){
        clientService.saveClient(client);
        return "redirect:/clients/showAll";
    }

    @RequestMapping("/getOne")
    public  @ResponseBody Client getOne(Long id) {
        return clientService.getOne(id);
    }

    @RequestMapping(value="/edit",method = {RequestMethod.PUT,RequestMethod.GET})
    public String showEditForm(@ModelAttribute Client client){
        client.getAddress();
        clientService.update(client);
        System.out.println(client.getId());
       return "redirect:/clients/showAll";
    }



    @RequestMapping(value="/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
        return "redirect:/clients/showAll";
    }


    public void addAttributes(Model model){
        model.addAttribute("client",new Client());
        model.addAttribute("clientsList",clientService.getClients());
    }


}
