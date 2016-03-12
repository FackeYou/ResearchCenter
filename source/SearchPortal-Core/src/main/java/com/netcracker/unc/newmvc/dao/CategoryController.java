package com.netcracker.unc.newmvc.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.netcracker.unc.priorityModule.CalculationPriority;

public class CategoryController {
	
	private UserModel userModel = null;

	public List<CategoryModel> getCategoriesWithPriorities() {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<CategoryModel> categoryModels = new ArrayList<CategoryModel>(categoryDAO.getAllCategoriesUser(userModel.getUserId()));
		double sumIncome = 700;//затычка. Значение будет получатся из юзера
		CalculationPriority calculationPriority = new CalculationPriority(categoryModels, sumIncome);
		categoryModels = calculationPriority.toCalculate();

		if (categoryModels.isEmpty())
			categoryModels = Collections.emptyList();
		return categoryModels;
	}

	public List<CategoryModel> getCategoriesWithSum(int userId) {
		CategoryDAO categoryDAO = new CategoryDAO();
		List<CategoryModel> categoryModels = new ArrayList<CategoryModel>(categoryDAO.getAllCategoriesUser(userId));
		if (categoryModels.isEmpty())
			categoryModels = Collections.emptyList();
		return categoryModels;
	}

	public CategoryController() {
	}

	public CategoryController(UserModel user) {
		this.userModel = user;
	}
}
