package com.example.weekfourchallenge;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    public static long idCounter = 0;

    ArrayList<Post> posts = new ArrayList<>();

    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/postForm")
    public String enterPost(Model model){
        Post newPost = new Post();
        idSetter(newPost);
        model.addAttribute("post", newPost);
        return "postform";
    }
    @PostMapping("/displayPost")
    public String displayPost(@Valid Post post,
                              BindingResult result){
        if (result.hasErrors()){
            return "postform";
        }else{
            posts.add(post);
            return "displayPost";
        }
    }
    @GetMapping("/allPosts")
    public String showAll(Model model){
        model.addAttribute("posts", posts);
        return "allposts";
    }
    static void idSetter(Post post){
        idCounter = idCounter + 1;
        post.setId(idCounter);
    }
}




