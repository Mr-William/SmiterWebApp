package com.org.njproject.smiter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.njproject.smiter.api.dao.GroupDAO;
import com.org.njproject.smiter.api.model.Group;
import com.org.njproject.smiter.api.model.User;
import com.org.njproject.smiter.api.service.LoginService;
import com.org.njproject.smiter.app.model.GroupImpl;
import com.org.njproject.smiter.app.model.TaskImpl;

@Controller
public class GroupController {
	
	
	@Autowired
	private GroupDAO groups;
	@Autowired
	private LoginService loginService;
	boolean active;
	
	@GetMapping("groupdetailpage")
	public String getGroupPage(@RequestParam String groupName,
							   @ModelAttribute("group") GroupImpl group, Model model) {
		
		active  = loginService.isLoggedIn();
		Group ret = groups.findGroupsByName(groupName);
		model.addAttribute("group", ret);
		model.addAttribute("message", groupName + " Group Detail Page");
		model.addAttribute("loggedIn", active);
		model.addAttribute("taskList", ret.getTaskList());
		return "groupdetailpage";
	}
	
	@GetMapping("creategroup")
	public String getCreateGroupPage(Model model) {
		
		active  = loginService.isLoggedIn();
		Group group = new GroupImpl();
		model.addAttribute("group", group);
		model.addAttribute("loggedIn", active);
		return "groupcreatepage";
	}
	
	@PostMapping("creategroup")
	public String createGroup(@ModelAttribute("group")GroupImpl group, Model model) {
		
		User o = loginService.getLoggedIn();
		active  = loginService.isLoggedIn();
		if(groups.createGroup(group) != null) {
			group.setOwner(o);
			o.joinGroup(group.getName());
			model.addAttribute("message", "Group '" + group.getName() + "' successfully created!");			
		}else {
			model.addAttribute("error", "Group Already Exists!");
			}

		model.addAttribute("user", o);
		model.addAttribute("groups", o.memberOfGroups());
		model.addAttribute("loggedIn", active);		
		
		return "welcome";
	}
	
	@GetMapping("createtasklist")
	public String createTaskList(@RequestParam String groupName,
							    @ModelAttribute("group")GroupImpl group,
								@ModelAttribute("taskList")TaskImpl task, Model model) {
		
		model.addAttribute("task", new TaskImpl());
		model.addAttribute("groupName", groupName);
		return "createtasklist";
	}
	
	@PostMapping("createtasklist")
	public String createTask(@RequestParam String groupName,
							@ModelAttribute("task")TaskImpl task, Model model) {
		
		Group group = groups.findGroupsByName(groupName);
		group.addTask(task);
		User user = loginService.getLoggedIn();
		active = loginService.isLoggedIn();
		model.addAttribute("group", group);
		model.addAttribute("user", user);
		model.addAttribute("groups", user.memberOfGroups());
		return "welcome";
	}
	
	@GetMapping("tasklistinfo")
	public String viewTaskList(@RequestParam ("id")Long id,
								@ModelAttribute("taskList")TaskImpl task,
								@ModelAttribute("group")GroupImpl group, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("taskList", task);
		model.addAttribute("group", group);
		
		return "taskdetailpage";
	}
}
