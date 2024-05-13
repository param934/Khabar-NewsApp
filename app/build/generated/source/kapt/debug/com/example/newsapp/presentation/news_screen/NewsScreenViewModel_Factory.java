package com.example.newsapp.presentation.news_screen;

import com.example.newsapp.domain.repository.NewsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NewsScreenViewModel_Factory implements Factory<NewsScreenViewModel> {
  private final Provider<NewsRepository> newsRepositoryProvider;

  public NewsScreenViewModel_Factory(Provider<NewsRepository> newsRepositoryProvider) {
    this.newsRepositoryProvider = newsRepositoryProvider;
  }

  @Override
  public NewsScreenViewModel get() {
    return newInstance(newsRepositoryProvider.get());
  }

  public static NewsScreenViewModel_Factory create(
      Provider<NewsRepository> newsRepositoryProvider) {
    return new NewsScreenViewModel_Factory(newsRepositoryProvider);
  }

  public static NewsScreenViewModel newInstance(NewsRepository newsRepository) {
    return new NewsScreenViewModel(newsRepository);
  }
}
