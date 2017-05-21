package com.cyz.staticsystem.basic.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：用户组别模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-03-01
 */
public class UserGroup extends Model{
	
	
		            /**
	                 * 组别ID(主键)
	                 **/
				   			private String id;
				   			private String groupPId;
		   		
		            /**
	                 * 组别名
	                 **/
				   			private String groupName;
		   		
		            /**
	                 * 组别描述
	                 **/
				   			private String groupDesc;
		   		
		            /**
	                 * 组别状态
	                 **/
				   			private String groupStates;
		   		
		            /**
	                 * 创建者ID
	                 **/
				   			private String groupCreater;
				   			private String groupCreaterName;
		   		
		            /**
	                 * 更新者ID
	                 **/
				   			private String groupUpdater;
				   			private String groupUpdaterName;
		   		
		            /**
	                 * 创建时间
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
			private Date groupCreateTime;
		
		            /**
	                 * 更新时间
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
			private Date groupUpdateTime;
		
	
				
		  			/**
			 * 获取 组别ID(主键)
			 * @return String this.id
			 */
			public String getId(){
				return this.id;
			}
			
			/**
			 * 设置 组别ID(主键)
			 * @param String id 
			 */
			public void setId(String id){
				this.id = id;
			}
		   		
		
		
			
						
  			public String getGroupPId() {
				return this.groupPId;
			}

			public void setGroupPId(String groupPId) {
				this.groupPId = groupPId;
			}

					/**
			 * 获取 组别名
			 * @return String this.groupName
			 */
			public String getGroupName(){
				return this.groupName;
			}
			
			/**
			 * 设置 组别名
			 * @param String groupName 
			 */
			public void setGroupName(String groupName){
				this.groupName = groupName;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 组别描述
			 * @return String this.groupDesc
			 */
			public String getGroupDesc(){
				return this.groupDesc;
			}
			
			/**
			 * 设置 组别描述
			 * @param String groupDesc 
			 */
			public void setGroupDesc(String groupDesc){
				this.groupDesc = groupDesc;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 组别状态
			 * @return String this.groupStates
			 */
			public String getGroupStates(){
				return this.groupStates;
			}
			
			/**
			 * 设置 组别状态
			 * @param String groupStates 
			 */
			public void setGroupStates(String groupStates){
				this.groupStates = groupStates;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 创建者ID
			 * @return String this.groupCreater
			 */
			public String getGroupCreater(){
				return this.groupCreater;
			}
			
			/**
			 * 设置 创建者ID
			 * @param String groupCreater 
			 */
			public void setGroupCreater(String groupCreater){
				this.groupCreater = groupCreater;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 更新者ID
			 * @return String this.groupUpdater
			 */
			public String getGroupUpdater(){
				return this.groupUpdater;
			}
			
			/**
			 * 设置 更新者ID
			 * @param String groupUpdater 
			 */
			public void setGroupUpdater(String groupUpdater){
				this.groupUpdater = groupUpdater;
			}
		   		
		
		
			
								/**
			 * 获取 创建时间
			 * @return Date this.groupCreateTime
			 */
			public Date getGroupCreateTime(){
				return this.groupCreateTime;
			}
			
			/**
			 * 设置 创建时间
			 * @param Date groupCreateTime 
			 */
			public void setGroupCreateTime(Date groupCreateTime){
				this.groupCreateTime = groupCreateTime;
			}
								/**
			 * 获取 更新时间
			 * @return Date this.groupUpdateTime
			 */
			public Date getGroupUpdateTime(){
				return this.groupUpdateTime;
			}
			
			/**
			 * 设置 更新时间
			 * @param Date groupUpdateTime 
			 */
			public void setGroupUpdateTime(Date groupUpdateTime){
				this.groupUpdateTime = groupUpdateTime;
			}

			public String getGroupCreaterName() {
				return groupCreaterName;
			}

			public void setGroupCreaterName(String groupCreaterName) {
				this.groupCreaterName = groupCreaterName;
			}

			public String getGroupUpdaterName() {
				return groupUpdaterName;
			}

			public void setGroupUpdaterName(String groupUpdaterName) {
				this.groupUpdaterName = groupUpdaterName;
			}

		}