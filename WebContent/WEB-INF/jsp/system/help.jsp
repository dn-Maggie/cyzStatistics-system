<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html lang="en">
	<head>
		<%@ include file="../common/ace.jsp"%>
		<script src="<%=request.getContextPath() %>/static/js/jquery.slimscroll.min.js"></script>
	</head>
	<body>
		<div class="page-content">
						<div class="page-header">
							<h1>
								帮助文档
								<small>
									<i class="icon-double-angle-right"></i>
									系统使用说明
								</small>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="tabbable">
									<ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab">
										<li class="active">
											<a data-toggle="tab" href="#faq-tab-1">
												<i class="blue icon-question-sign bigger-120"></i>
												初始信息录入
											</a>
										</li>

										<li>
											<a data-toggle="tab" href="#faq-tab-2">
												<i class="green icon-user bigger-120"></i>
												用户账户分配
											</a>
										</li>

										<li>
											<a data-toggle="tab" href="#faq-tab-3">
												<i class="orange icon-credit-card bigger-120"></i>
												财务数据统计
											</a>
										</li>

										<li class="dropdown">
											<a data-toggle="tab" href="#faq-tab-4">
												<i class="purple icon-magic bigger-120"></i>
												系统使用
											</a>

										</li><!-- /.dropdown -->
									</ul>

									<div class="tab-content no-border padding-24">
										<div id="faq-tab-1" class="tab-pane fade in active">
											<h4 class="blue">
												<i class="icon-ok bigger-110"></i>
												关于初始信息录入问题
											</h4>

											<div class="space-8"></div>

											<div id="faq-list-1" class="panel-group accordion-style1 accordion-style2">
												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-1-1" data-parent="#faq-list-1" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-chevron-left pull-right" data-icon-hide="icon-chevron-down" data-icon-show="icon-chevron-left"></i>

															<i class="icon-user bigger-130"></i>
															&nbsp; 使用系统前需要录入哪些基础数据？
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-1-1">
														<div class="panel-body">
															基础数据包括：行业分类、品类管理、品牌管理、店铺基本信息、用户管理模块。
														</div>
													</div>
												</div>

												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-1-2" data-parent="#faq-list-1" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-chevron-left pull-right" data-icon-hide="icon-chevron-down" data-icon-show="icon-chevron-left"></i>
															<i class="icon-sort-by-attributes-alt"></i>
															&nbsp; 如何录入基础数据？
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-1-2">
														<div class="panel-body">
															<div id="faq-list-nested-1" class="panel-group accordion-style1 accordion-style2">
																<div class="panel panel-default">
																	<div class="panel-heading">
																		<a href="#faq-list-1-sub-1" data-parent="#faq-list-nested-1" data-toggle="collapse" class="accordion-toggle collapsed">
																			<i class="icon-plus smaller-80 middle" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
																			&nbsp; 如何录入行业分类及品类数据？
																		</a>
																	</div>

																	<div class="panel-collapse collapse" id="faq-list-1-sub-1">
																		<div class="panel-body">
																			<br/>登录管理员账号，点击左边菜单，行业分类/品类管理，点击新增。
																			<img alt="010101.png" src="<%=request.getContextPath()%>/tempFile/010101.png">
																		</div>
																	</div>
																</div>

																<div class="panel panel-default">
																	<div class="panel-heading">
																		<a href="#faq-list-1-sub-2" data-parent="#faq-list-nested-1" data-toggle="collapse" class="accordion-toggle collapsed">
																			<i class="icon-plus smaller-80 middle" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
																			&nbsp;如何录入品牌数据？
																		</a>
																	</div>

																	<div class="panel-collapse collapse" id="faq-list-1-sub-2">
																		<div class="panel-body">
																			<br/>登录管理员账号，按要求将品牌录入好。
																			<img alt="020101.png" src="<%=request.getContextPath()%>/tempFile/020101.png">
																		</div>
																	</div>
																</div>

																<div class="panel panel-default">
																	<div class="panel-heading">
																		<a href="#faq-list-1-sub-3" data-parent="#faq-list-nested-1" data-toggle="collapse" class="accordion-toggle collapsed">
																			<i class="icon-plus smaller-80 middle" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
																			&nbsp;如何录入店铺基本信息？
																		</a>
																	</div>

																	<div class="panel-collapse collapse" id="faq-list-1-sub-3">
																		<div class="panel-body">
																			<br/>登录管理员账号，依次录入，或下载模板之后批量导入各店铺基础信息。
																			<img alt="020103.png" src="<%=request.getContextPath()%>/tempFile/020103.png">
																			<img alt="0201032.png" src="<%=request.getContextPath()%>/tempFile/0201032.png">
																			<img alt="0201033.png" src="<%=request.getContextPath()%>/tempFile/0201033.png">
																		</div>
																	</div>
																</div>
																
																<div class="panel panel-default">
																	<div class="panel-heading">
																		<a href="#faq-list-1-sub-4" data-parent="#faq-list-nested-1" data-toggle="collapse" class="accordion-toggle collapsed">
																			<i class="icon-plus smaller-80 middle" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
																			&nbsp;如何录入用户账号信息？
																		</a>
																	</div>

																	<div class="panel-collapse collapse" id="faq-list-1-sub-4">
																		<div class="panel-body">
																			<br/>通过管理员账号，进入基础数据->用户管理 ，点击一个小组，增加平台店铺账号
																			<img alt="020104.png" src="<%=request.getContextPath()%>/tempFile/020104.png">
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div id="faq-tab-2" class="tab-pane fade">
											<h4 class="blue">
												<i class="green icon-user bigger-110"></i>
												关于用户账户分配问题
											</h4>

											<div class="space-8"></div>

											<div id="faq-list-2" class="panel-group accordion-style1 accordion-style2">
												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-2-1" data-parent="#faq-list-2" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-chevron-right smaller-80" data-icon-hide="icon-chevron-down align-top" data-icon-show="icon-chevron-right"></i>
															&nbsp;如何将店铺信息与用户账户进行关联？
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-2-1">
														<div class="panel-body">
															<br/>进入店铺基础信息，将店铺关联账号修改成平台店铺账号。
															<img alt="0104.png" src="<%=request.getContextPath()%>/tempFile/0104.png">
														</div>
													</div>
												</div>
											</div>
										</div>

										<div id="faq-tab-3" class="tab-pane fade">
											<h4 class="blue">
												<i class="orange icon-credit-card bigger-110"></i>
												财务数据统计模块的使用
											</h4>

											<div class="space-8"></div>

											<div id="faq-list-3" class="panel-group accordion-style1 accordion-style2">
												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-3-1" data-parent="#faq-list-3" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-plus smaller-80" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
															&nbsp;如何查看订单明细?
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-3-1">
														<div class="panel-body">
															<br/>进入菜单 财务统计->订单明细，输入商户名称，点击查询，获取该店铺的所有订单明细。
															<img alt="030101.png" src="<%=request.getContextPath()%>/tempFile/030101.png">
															<br/>可通过“导出数据”按钮将数据导出为EXCEL。
															<br/>可通过“下载模板”，按格式要求填入数据之后，通过“导入原始数据”按钮将原始订单数据导入。
														</div>
													</div>
												</div>

												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-3-2" data-parent="#faq-list-3" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-plus smaller-80" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
															&nbsp;如何生成运营表?
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-3-2">
														<div class="panel-body">
															<br/>以蔡记为例，先进入菜单 财务统计->订单明细，输入商户名称，点击查询，获取该店铺的所有订单明细。
															<br/>点击该商铺的结算方式，生成相应表格。
															<img alt="030102.png" src="<%=request.getContextPath()%>/tempFile/030102.png">
														</div>
													</div>
												</div>

												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-3-3" data-parent="#faq-list-3" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-plus smaller-80" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
															&nbsp;如何查看运营数据？
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-3-3">
														<div class="panel-body">
															<br/>进入菜单 财务统计->运营数据，点击对应运营表查看数据。
															<img alt="030103.png" src="<%=request.getContextPath()%>/tempFile/030103.png">
															<br/>点击“查看汇总信息”，可以查看运营表汇总。
														</div>
													</div>
												</div>

												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-3-4" data-parent="#faq-list-3" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-plus smaller-80" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
															&nbsp;如何查看菜品分析表？
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-3-4">
														<div class="panel-body">
															<br/>进入菜单 财务统计->菜品分析，点击查看菜品分析。
														</div>
													</div>
												</div>
												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-3-5" data-parent="#faq-list-3" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-plus smaller-80" data-icon-hide="icon-minus" data-icon-show="icon-plus"></i>
															&nbsp;如何查看运营汇总（深运营、浅运营）？
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-3-5">
														<div class="panel-body">
															<br/>进入菜单 财务统计->运营汇总，点击查看深运营表、浅运营表。
														</div>
													</div>
												</div>
											</div>
										</div>

										<div id="faq-tab-4" class="tab-pane fade">
											<h4 class="blue">
												<i class="purple icon-magic bigger-110"></i>
												本系统使用说明
											</h4>

											<div class="space-8"></div>

											<div id="faq-list-4" class="panel-group accordion-style1 accordion-style2">
												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-4-1" data-parent="#faq-list-4" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-hand-right" data-icon-hide="icon-hand-down" data-icon-show="icon-hand-right"></i>
															&nbsp;
															如何添加用户?
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-4-1">
														<div class="panel-body">
															Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et.
														</div>
													</div>
												</div>

												<div class="panel panel-default">
													<div class="panel-heading">
														<a href="#faq-4-2" data-parent="#faq-list-4" data-toggle="collapse" class="accordion-toggle collapsed">
															<i class="icon-hand-right" data-icon-hide="icon-hand-down" data-icon-show="icon-hand-right"></i>
															&nbsp;
					  										如何进行角色授权？
														</a>
													</div>

													<div class="panel-collapse collapse" id="faq-4-2">
														<div class="panel-body">
															Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et.
														</div>
													</div>
												</div>


											</div>
										</div>
									</div>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div>
		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($) {
				$('.accordion').on('hide', function (e) {
					$(e.target).prev().children(0).addClass('collapsed');
				})
				$('.accordion').on('show', function (e) {
					$(e.target).prev().children(0).removeClass('collapsed');
				})
			});
		</script>
	</body>
</html>

