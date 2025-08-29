package com.java_interview_tech_questionnaires.custom_annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

/**
 * @author RavikantS on Aug 22, 2025
 */
@SupportedAnnotationTypes("com.ideyalabs.batch.virtual.custom_annotations.CustomBuilder")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class BaseBuilderHandler extends AbstractProcessor {
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(CustomBuilder.class);
		for (Element e : elementsAnnotatedWith) {
			if (e.getKind() != ElementKind.CLASS) {
				continue;
			}
			TypeElement e1 = (TypeElement) e;
			String className = e1.getSimpleName().toString();
			String packageName = processingEnv.getElementUtils().getPackageOf(e1).toString();
			String builderClassName = className + "Builder";
			
			try {
				JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(packageName + "." + builderClassName);
				try (Writer writer = sourceFile.openWriter()) {
					writer.write("package " + packageName + ";\n\n");
					writer.write("public class " + builderClassName + " {\n");
					
					for (Element enclosingElement : e1.getEnclosedElements()) {
						if (enclosingElement.getKind().equals(ElementKind.FIELD)) {
							String fieldName = enclosingElement.getSimpleName().toString();
							String fieldType = enclosingElement.asType().toString();
							
						}
					}
					
				}
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
		return false;
	}
}
