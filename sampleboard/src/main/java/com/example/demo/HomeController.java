package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
  @Autowired
  private MessageService messageService;


  //掲示板表示
  @RequestMapping("/")
  public String index(ModelMap modelMap) {
    List<Message> messages = messageService.findAll();
    modelMap.addAttribute("messages", messages);
    return "board";
  }
  //掲示板に投稿する
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public String create(@ModelAttribute MessageForm messageForm, ModelMap modelMap) {
    Message message = new Message();
    message.name = messageForm.getName();
    message.message = messageForm.getMessage();
    messageService.save(message);

    return "redirect:/";
  }

  //削除
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public String destroy(@PathVariable Long id) {
	  messageService.delete(id);
      return "redirect:/";
  }

  //編集ページの内容を表示させる
  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  public String getEdit(@PathVariable Long id, ModelMap modelMap) {
    Message message = messageService.findOne(id);
    modelMap.addAttribute("message", message);
    return "edit";
  }

  //編集ページでメッセージを取得し、更新する
  @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
  public String update(@PathVariable Long id, @ModelAttribute Message message) {
   //これでid取れたことになってるのかわからない
    messageService.save(message);

    return "board";
  }

}