package tn.esprit.TRAVELGO.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.TRAVELGO.entities.Post;
import tn.esprit.TRAVELGO.repository.PostRepository;
import tn.esprit.TRAVELGO.repository.UserRepository;

import java.util.*;



@Service
public class PostServiceImpl  {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	



	
	
	public Post getPostById(Long id) {
		// TODO Auto-generated method stub
		Post p = postRepository.findById(id).get();
		int countViews =0;
		
		if(p == null) return null;
		
		p.setViews(p.getViews()+1);
		//
		countViews = postRepository.updateViewCountPost(p.getViews() -1, id);
		countViews++;
		
		return p;
		
		
	}

	public Map<Long, Integer> getPostsbyViewes() { 
		
		List<Long>listId = new ArrayList<>();
		List<Integer>listViews = new ArrayList<>();
		
		Map<Long,Integer>map = new HashMap<>();
		
		for(Post p : postRepository.findAll()) {
			listId.add(p.getId());
			listViews.add(p.getViews());
		}
		List<Integer>sortedList = new ArrayList<>(listViews);
		
		Collections.sort(sortedList);
		for(int i = 0 ; i< 2; i++) {
			int max = sortedList.get(sortedList.size()-1);
			long postid= listId.get(listViews.indexOf(max));
			map.put(postid, max);
			
			System.out.println("post numbero :"+postid+  " ---------- views :"+max);
			sortedList.remove(sortedList.size() -1)  ;
			listViews.set(listViews.indexOf(max),-1);
		}
		
		return map;
		
	
	}
		
	}
	


