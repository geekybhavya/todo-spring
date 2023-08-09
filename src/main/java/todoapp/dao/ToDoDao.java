
package todoapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import todoapp.model.Activity;

@Component
public class ToDoDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// create
	@Transactional
	public void createActivity(Activity activ) {

		this.hibernateTemplate.save(activ);

	}

	// get all activs
	public List<Activity> getActivitys() {
		List<Activity> activs = this.hibernateTemplate.loadAll(Activity.class);
		return activs;
	}

	// delete the single activ
	@Transactional
	public void deleteActivity(int pid) {
		Activity p = this.hibernateTemplate.load(Activity.class, pid);
		this.hibernateTemplate.delete(p);
	}

	// get the single activ
	public Activity getActivity(int pid) {
		return this.hibernateTemplate.get(Activity.class, pid);
	}
}