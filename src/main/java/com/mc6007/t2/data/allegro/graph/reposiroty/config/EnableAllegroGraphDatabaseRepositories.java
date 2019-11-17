package com.mc6007.t2.data.allegro.graph.reposiroty.config;

import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Import;
import org.springframework.data.keyvalue.repository.config.QueryCreatorType;
import org.springframework.data.keyvalue.repository.query.CachingKeyValuePartTreeQuery;
import org.springframework.data.keyvalue.repository.query.SpelQueryCreator;
import org.springframework.data.keyvalue.repository.support.KeyValueRepositoryFactoryBean;
import org.springframework.data.repository.config.DefaultRepositoryBaseClass;
import org.springframework.data.repository.query.QueryLookupStrategy;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.springframework.data.repository.query.QueryLookupStrategy.Key;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(AllegroGraphDatabaseRepositoriesRegistrar.class)
@QueryCreatorType(value = SpelQueryCreator.class, repositoryQueryType = CachingKeyValuePartTreeQuery.class)
public @interface EnableAllegroGraphDatabaseRepositories {

    /**
     * Alias for the {@link #basePackages()} attribute. Allows for more concise annotation declarations e.g.:
     * {@code @EnableJpaRepositories("org.my.pkg")} instead of {@code @EnableJpaRepositories(basePackages="org.my.pkg")}.
     */
    String[] value() default {};

    /**
     * Base packages to scan for annotated components. {@link #value()} is an alias for (and mutually exclusive with) this
     * attribute. Use {@link #basePackageClasses()} for a type-safe alternative to String-based package names.
     */
    String[] basePackages() default {};

    /**
     * Type-safe alternative to {@link #basePackages()} for specifying the packages to scan for annotated components. The
     * package of each class specified will be scanned. Consider creating a special no-op marker class or interface in
     * each package that serves no purpose other than being referenced by this attribute.
     */
    Class<?>[] basePackageClasses() default {};

    /**
     * Specifies which types are not eligible for component scanning.
     */
    Filter[] excludeFilters() default {};

    /**
     * Specifies which types are eligible for component scanning. Further narrows the set of candidate components from
     * everything in {@link #basePackages()} to everything in the base packages that matches the given filter or filters.
     */
    Filter[] includeFilters() default {};

    /**
     * Returns the postfix to be used when looking up custom repository implementations. Defaults to {@literal Impl}. So
     * for a repository named {@code PersonRepository} the corresponding implementation class will be looked up scanning
     * for {@code PersonRepositoryImpl}.
     *
     * @return
     */
    String repositoryImplementationPostfix() default "Impl";

    /**
     * Configures the location of where to find the Spring Data named queries properties file.
     *
     * @return
     */
    String namedQueriesLocation() default "";

    /**
     * Returns the key of the {@link QueryLookupStrategy} to be used for lookup queries for query methods. Defaults to
     * {@link Key#CREATE_IF_NOT_FOUND}.
     *
     * @return
     */
    Key queryLookupStrategy() default Key.CREATE_IF_NOT_FOUND;

    /**
     * Returns the {@link FactoryBean} class to be used for each repository instance. Defaults to
     * {@link KeyValueRepositoryFactoryBean}.
     *
     * @return
     */
    Class<?> repositoryFactoryBeanClass() default KeyValueRepositoryFactoryBean.class;

    /**
     * Configure the repository base class to be used to create repository proxies for this particular configuration.
     *
     * @return
     */
    Class<?> repositoryBaseClass() default DefaultRepositoryBaseClass.class;

    /**
     * Configures the name of the {@link KeyValueOperations} bean to be used with the repositories detected.
     *
     * @return
     */
    String keyValueTemplateRef() default "allegroGraphDatabaseDocumentTemplate";

    /**
     * Configures whether nested repository-interfaces (e.g. defined as inner classes) should be discovered by the
     * repositories infrastructure.
     */
    boolean considerNestedRepositories() default false;

    /**
     * It configures the db name used for the repository
     * @return
     */
    //String dbName() default "dbName";
}
